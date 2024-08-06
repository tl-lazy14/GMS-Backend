package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.config.VNPayConfig;
import com.example.gms_backend.dto.request.*;
import com.example.gms_backend.dto.response.*;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.repository.*;
import com.example.gms_backend.service.CustomerService;
import com.example.gms_backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final NonMemberCustomerRepository nonMemberCustomerRepository;
    private final MemberRepository memberRepository;
    private final MemberServiceRepository memberServiceRepository;
    private final GymRepository gymRepository;
    private final BrandInfoRepository brandInfoRepository;
    private final RevenueRepository revenueRepository;
    private final MemberRegistrationTransferRepository memberRegistrationTransferRepository;
    private final TrialRegistrationRepository trialRegistrationRepository;
    private final MembershipRepository membershipRepository;
    private final EmailService emailService;
    private final WorkoutResultRepository workoutResultRepository;
    private final CoachScheduleRepository coachScheduleRepository;
    private final ClassMemberRepository classMemberRepository;
    private final PersonalTrainerPackageRepository personalTrainerPackageRepository;
    private final CoachRepository coachRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public GetListNonMemCustomerRes getListNonMemCustomer(String gymId, String date, String keyword, int page, int pageSize) throws ParseException {
        Pageable pageable = PageRequest.of(page, pageSize);
        Date selectedDate = dateFormat.parse(date);
        List<NonMemberCustomer> list = nonMemberCustomerRepository.getListNonMemCustomer(gymId, selectedDate, keyword, pageable);
        int num = nonMemberCustomerRepository.countListNonMemCustomer(gymId, selectedDate, keyword);
        return GetListNonMemCustomerRes.builder()
                .listItem(list)
                .numItem(num)
                .build();
    }

    @Override
    public List<NonMemberCustomer> exportListNonMemCustomer(String gymId, String date) throws ParseException {
        Date selectedDate = dateFormat.parse(date);
        return nonMemberCustomerRepository.exportListNonMemCustomer(gymId, selectedDate);
    }

    @Override
    public void addNonMemCustomer(NonMemCustomerReq request) {
        NonMemberCustomer nonMemberCustomer = new NonMemberCustomer();
        nonMemberCustomer.setName(request.getName());
        nonMemberCustomer.setPhone(request.getPhone());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        nonMemberCustomer.setGym(gym);
        BrandInfo brandInfo = brandInfoRepository.findFirstByOrderByIdAsc();
        nonMemberCustomer.setAmount(brandInfo.getDayPassFee());
        nonMemberCustomer.setCheckInTime(new Date());
        nonMemberCustomer.setCreatedAt(new Date());
        nonMemberCustomer.setUpdatedAt(new Date());
        nonMemberCustomerRepository.save(nonMemberCustomer);

        LocalDate currentDate = LocalDate.now();
        Integer currentYear = currentDate.getYear();
        Integer currentMonth = currentDate.getMonthValue();
        System.out.println(currentYear + " " + currentMonth);
        Optional<Revenue> revenueOptional = revenueRepository.findByMonthAndYear(currentYear, currentMonth, request.getGymId());
        System.out.println(revenueOptional);
        if (revenueOptional.isPresent()) {
            Revenue revenue = revenueOptional.get();
            Double currentNonMemRevenue = revenue.getNonMemRevenue();
            revenue.setNonMemRevenue(currentNonMemRevenue + brandInfo.getDayPassFee());
            revenueRepository.save(revenue);
        } else {
            Revenue newRevenueMonth = new Revenue();
            newRevenueMonth.setMonth(currentMonth);
            newRevenueMonth.setYear(currentYear);
            newRevenueMonth.setNonMemRevenue(brandInfo.getDayPassFee());
            newRevenueMonth.setMembershipRevenue((double) 0);
            newRevenueMonth.setPtServiceRevenue((double) 0);
            newRevenueMonth.setGym(gym);
            newRevenueMonth.setCreatedAt(new Date());
            revenueRepository.save(newRevenueMonth);
        }
    }

    @Override
    public void editNonMemCustomer(String id, NonMemCustomerReq request) {
        NonMemberCustomer nonMemberCustomer = nonMemberCustomerRepository.findById(id).orElseThrow();
        nonMemberCustomer.setName(request.getName());
        nonMemberCustomer.setPhone(request.getPhone());
        nonMemberCustomer.setUpdatedAt(new Date());
        nonMemberCustomerRepository.save(nonMemberCustomer);
    }

    @Override
    public void deleteNonMemCustomer(String id) {
        NonMemberCustomer nonMemberCustomer = nonMemberCustomerRepository.findById(id).orElseThrow();
        nonMemberCustomerRepository.delete(nonMemberCustomer);
    }

    @Override
    public GetListTransferRegistrationRes getListTransferRegistration(String membershipId, String status, String gymId, String keyword, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<MemberRegistrationTransfer> list = memberRegistrationTransferRepository.getList(membershipId, status, gymId, keyword, pageable);
        int num = memberRegistrationTransferRepository.countList(membershipId, status, gymId, keyword);
        return GetListTransferRegistrationRes.builder()
                .listItem(list)
                .numItem(num)
                .build();
    }

    @Override
    public void createTransferRegistration(AddMemberReq request) throws ParseException {
        MemberRegistrationTransfer registrationTransfer = new MemberRegistrationTransfer();
        registrationTransfer.setName(request.getName());
        registrationTransfer.setEmail(request.getEmail());
        registrationTransfer.setPhone(request.getPhone());
        registrationTransfer.setGender(request.getGender());
        registrationTransfer.setDob(dateFormat.parse(request.getDob()));
        Membership membership = membershipRepository.findById(request.getMembershipId()).orElseThrow();
        registrationTransfer.setMembership(membership);
        registrationTransfer.setStartDate(dateFormat.parse(request.getStartDate()));
        registrationTransfer.setEndDate(dateFormat.parse(request.getEndDate()));
        registrationTransfer.setAmount(request.getAmount());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        registrationTransfer.setGym(gym);
        registrationTransfer.setStatus("Pending");
        registrationTransfer.setCreatedAt(new Date());
        registrationTransfer.setUpdatedAt(new Date());
        memberRegistrationTransferRepository.save(registrationTransfer);
    }

    @Override
    public void handleApprove(String id, String status) {
        MemberRegistrationTransfer registration = memberRegistrationTransferRepository.findById(id).orElseThrow();
        registration.setStatus(status);
        memberRegistrationTransferRepository.save(registration);
        if (Objects.equals(status, "Approved")) {
            Member member = new Member();
            member.setCode(generateCode(registration.getName()));
            member.setName(registration.getName());
            member.setEmail(registration.getEmail());
            member.setPhone(registration.getPhone());
            member.setGender(registration.getGender());
            member.setDob(registration.getDob());
            member.setGym(registration.getGym());
            member.setCreatedAt(new Date());
            member.setUpdatedAt(new Date());
            memberRepository.save(member);

            MemberService memberService = new MemberService();
            memberService.setMember(member);
            memberService.setMembership(registration.getMembership());
            memberService.setStartDate(registration.getStartDate());
            memberService.setEndDate(registration.getEndDate());
            memberService.setAmount(registration.getAmount());
            memberService.setStatus(checkDateStatus(registration.getStartDate(), registration.getEndDate()));
            memberService.setIsSentMail(0);
            memberService.setCreatedAt(new Date());
            memberService.setUpdatedAt(new Date());
            memberServiceRepository.save(memberService);

            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            int currentMonth = currentDate.getMonthValue();
            Optional<Revenue> revenueOptional = revenueRepository.findByMonthAndYear(currentYear, currentMonth, registration.getGym().getId());
            if (revenueOptional.isPresent()) {
                Revenue revenue = revenueOptional.get();
                Double currentMembershipRevenue = revenue.getMembershipRevenue();
                revenue.setMembershipRevenue(currentMembershipRevenue + registration.getAmount());
                revenueRepository.save(revenue);
            } else {
                Revenue newRevenueMonth = new Revenue();
                newRevenueMonth.setMonth(currentMonth);
                newRevenueMonth.setYear(currentYear);
                newRevenueMonth.setNonMemRevenue((double) 0);
                newRevenueMonth.setMembershipRevenue(registration.getAmount());
                newRevenueMonth.setPtServiceRevenue((double) 0);
                newRevenueMonth.setGym(registration.getGym());
                newRevenueMonth.setCreatedAt(new Date());
                revenueRepository.save(newRevenueMonth);
            }

            emailService.sendMembershipRegistration(registration.getEmail(),
                    registration.getName(),
                    registration.getMembership().getName(),
                    registration.getStartDate(),
                    registration.getEndDate(),
                    registration.getAmount());
        }
    }

    public static String generateCode(String name) {
        char firstChar = Character.toUpperCase(name.charAt(0));
        String randomNumbers = generateRandomNumbers();
        return firstChar + randomNumbers;
    }

    private static String generateRandomNumbers() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(7);

        for (int i = 0; i < 7; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }

        return sb.toString();
    }

    public static String checkDateStatus(Date startDate, Date endDate) {
        LocalDate startLocalDate = convertToLocalDate(startDate);
        LocalDate endLocalDate = convertToLocalDate(endDate);
        LocalDate today = LocalDate.now();

        if (today.isBefore(startLocalDate)) {
            return "Upcoming";
        } else if (!today.isAfter(endLocalDate)) {
            if (today.plusWeeks(2).isAfter(endLocalDate)) {
                return "Expiring Soon";
            } else {
                return "Active";
            }
        } else {
            return "Expired";
        }
    }

    public static String checkDatePTServiceStatus(Date startDate, Date endDate) {
        LocalDate startLocalDate = convertToLocalDate(startDate);
        LocalDate endLocalDate = convertToLocalDate(endDate);
        LocalDate today = LocalDate.now();

        if (today.isBefore(startLocalDate)) {
            return "Upcoming";
        } else if (!today.isAfter(endLocalDate)) {
            return "Active";
        } else {
            return "Finished";
        }
    }

    private static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @Override
    public GetListTrialRegistrationRes getListTrialRegistration(String contactStatus, String approvalStatus, String gymId, String keyword, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<TrialRegistration> list = trialRegistrationRepository.getList(contactStatus, approvalStatus, gymId, keyword, pageable);
        int num = trialRegistrationRepository.countList(contactStatus, approvalStatus, gymId, keyword);
        return GetListTrialRegistrationRes.builder()
                .listItem(list)
                .numItem(num)
                .build();
    }

    @Override
    public List<TrialRegistration> exportListTrialRegistration(String contactStatus, String approvalStatus, String gymId) {
        return trialRegistrationRepository.exportList(contactStatus, approvalStatus, gymId);
    }

    @Override
    public void selectTrialDate(String id, String date) throws ParseException {
        TrialRegistration trialRegistration = trialRegistrationRepository.findById(id).orElseThrow();
        trialRegistration.setPreferredDate(dateFormat.parse(date));
        trialRegistrationRepository.save(trialRegistration);
    }

    @Override
    public void handleTrialContactStatus(String id, String status) {
        TrialRegistration trialRegistration = trialRegistrationRepository.findById(id).orElseThrow();
        trialRegistration.setStatusContact(status);
        trialRegistrationRepository.save(trialRegistration);
    }

    @Override
    public void handleTrialApprovalStatus(String id, String status) {
        TrialRegistration trialRegistration = trialRegistrationRepository.findById(id).orElseThrow();
        trialRegistration.setStatusApprove(status);
        trialRegistrationRepository.save(trialRegistration);
    }

    @Override
    public GetListMemberRes getListMember(String membershipId, String status, String gymId, String keyword, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<MemberInfoRes> listItem = new ArrayList<>();

        List<Member> memberList = memberRepository.searchByKeywordAndGym(gymId, keyword);
        for (Member member : memberList) {
            List<MemberService> memberServices = memberServiceRepository.findByMemberIdAndMembershipIsNotNullOrderByCreatedAtDesc(member.getId());
            MemberService currentMembershipService = memberServices.get(0);

            MemberInfoRes memberInfoRes = new MemberInfoRes();
            memberInfoRes.setId(member.getId());
            memberInfoRes.setMemberCode(member.getCode());
            memberInfoRes.setName(member.getName());
            memberInfoRes.setEmail(member.getEmail());
            memberInfoRes.setPhone(member.getPhone());
            memberInfoRes.setGender(member.getGender());
            memberInfoRes.setDob(member.getDob());
            memberInfoRes.setMembership(currentMembershipService.getMembership());
            memberInfoRes.setStartDate(currentMembershipService.getStartDate());
            memberInfoRes.setExpiredDate(currentMembershipService.getEndDate());
            memberInfoRes.setStatus(currentMembershipService.getStatus());
            listItem.add(memberInfoRes);
        }

        if (!Objects.equals(membershipId, "all")) {
            listItem = listItem.stream()
                    .filter(memberInfoRes -> memberInfoRes.getMembership().getId().equals(membershipId))
                    .collect(Collectors.toList());
        }

        if (!Objects.equals(status, "all")) {
            listItem = listItem.stream()
                    .filter(memberInfoRes -> memberInfoRes.getStatus().equals(status))
                    .collect(Collectors.toList());
        }

        int numItem = listItem.size();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listItem.size());
        Page<MemberInfoRes> memberInfoPage = new PageImpl<>(listItem.subList(start, end), pageable, listItem.size());

        return GetListMemberRes.builder()
                .listItem(memberInfoPage.getContent())
                .numItem(numItem)
                .build();
    }

    @Override
    public List<MemberInfoRes> exportListMember(String membershipId, String status, String gymId) {
        List<MemberInfoRes> listItem = new ArrayList<>();

        Gym gym = gymRepository.findById(gymId).orElseThrow();
        List<Member> memberList = memberRepository.findByGymOrderByCreatedAtDesc(gym);

        for (Member member : memberList) {
            List<MemberService> memberServices = memberServiceRepository.findByMemberIdAndMembershipIsNotNullOrderByCreatedAtDesc(member.getId());
            MemberService currentMembershipService = memberServices.get(0);

            MemberInfoRes memberInfoRes = new MemberInfoRes();
            memberInfoRes.setId(member.getId());
            memberInfoRes.setMemberCode(member.getCode());
            memberInfoRes.setName(member.getName());
            memberInfoRes.setEmail(member.getEmail());
            memberInfoRes.setPhone(member.getPhone());
            memberInfoRes.setGender(member.getGender());
            memberInfoRes.setDob(member.getDob());
            memberInfoRes.setMembership(currentMembershipService.getMembership());
            memberInfoRes.setStartDate(currentMembershipService.getStartDate());
            memberInfoRes.setExpiredDate(currentMembershipService.getEndDate());
            memberInfoRes.setStatus(currentMembershipService.getStatus());
            listItem.add(memberInfoRes);
        }

        if (!Objects.equals(membershipId, "all")) {
            listItem = listItem.stream()
                    .filter(memberInfoRes -> memberInfoRes.getMembership().getId().equals(membershipId))
                    .collect(Collectors.toList());
        }

        if (!Objects.equals(status, "all")) {
            listItem = listItem.stream()
                    .filter(memberInfoRes -> memberInfoRes.getStatus().equals(status))
                    .collect(Collectors.toList());
        }

        return listItem;
    }

    @Override
    public void addMember(AddMemberReq request) throws ParseException {
        Member member = new Member();
        member.setCode(generateCode(request.getName()));
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setGender(request.getGender());
        member.setDob(dateFormat.parse(request.getDob()));
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        member.setGym(gym);
        member.setCreatedAt(new Date());
        member.setUpdatedAt(new Date());
        memberRepository.save(member);

        MemberService memberService = new MemberService();
        memberService.setMember(member);
        Membership membership = membershipRepository.findById(request.getMembershipId()).orElseThrow();
        memberService.setMembership(membership);
        memberService.setStartDate(dateFormat.parse(request.getStartDate()));
        memberService.setEndDate(dateFormat.parse(request.getEndDate()));
        memberService.setAmount(request.getAmount());
        memberService.setStatus(checkDateStatus(dateFormat.parse(request.getStartDate()), dateFormat.parse(request.getEndDate())));
        memberService.setIsSentMail(0);
        memberService.setCreatedAt(new Date());
        memberService.setUpdatedAt(new Date());
        memberServiceRepository.save(memberService);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        Optional<Revenue> revenueOptional = revenueRepository.findByMonthAndYear(currentYear, currentMonth, request.getGymId());
        if (revenueOptional.isPresent()) {
            Revenue revenue = revenueOptional.get();
            Double currentMembershipRevenue = revenue.getMembershipRevenue();
            revenue.setMembershipRevenue(currentMembershipRevenue + request.getAmount());
            revenueRepository.save(revenue);
        } else {
            Revenue newRevenueMonth = new Revenue();
            newRevenueMonth.setMonth(currentMonth);
            newRevenueMonth.setYear(currentYear);
            newRevenueMonth.setNonMemRevenue((double) 0);
            newRevenueMonth.setMembershipRevenue(request.getAmount());
            newRevenueMonth.setPtServiceRevenue((double) 0);
            newRevenueMonth.setGym(gym);
            newRevenueMonth.setCreatedAt(new Date());
            revenueRepository.save(newRevenueMonth);
        }

        emailService.sendMembershipRegistration(request.getEmail(),
                request.getName(),
                membership.getName(),
                dateFormat.parse(request.getStartDate()),
                dateFormat.parse(request.getEndDate()),
                request.getAmount());
    }

    @Override
    public void editMemberInfo(String id, EditMemberInfoReq request) throws ParseException {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setGender(request.getGender());
        member.setDob(dateFormat.parse(request.getDob()));
        memberRepository.save(member);
    }

    @Scheduled(cron = "0 1 0 * * ?")
    public void checkAndSetStatusMembership() {
        List<MemberService> memberServiceList = memberServiceRepository.findAll();
        for (MemberService membershipService : memberServiceList) {
            if (membershipService.getMembership() != null) {
                String status = checkDateStatus(membershipService.getStartDate(), membershipService.getEndDate());
                membershipService.setStatus(status);
                memberServiceRepository.save(membershipService);
            }
        }
    }

    @Scheduled(cron = "0 2 0 * * ?")
    public void checkAndSetStatusPTService() {
        List<MemberService> memberServiceList = memberServiceRepository.findAll();
        for (MemberService ptService : memberServiceList) {
            if (ptService.getPersonalTrainerPackage() != null) {
                String status = checkDatePTServiceStatus(ptService.getStartDate(), ptService.getEndDate());
                ptService.setStatus(status);
                memberServiceRepository.save(ptService);
            }
        }
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void sendMailExpiringSoon() {
        List<MemberService> memberServiceList = memberServiceRepository.findAll();
        for (MemberService membershipService : memberServiceList) {
            if (membershipService.getMembership() != null &&
                    Objects.equals(membershipService.getStatus(), "Expiring Soon") &&
                    membershipService.getIsSentMail() == 0) {
                emailService.sendReminderExpiringSoon(membershipService.getMember().getEmail());
                membershipService.setIsSentMail(1);
                memberServiceRepository.save(membershipService);
            }
        }
    }

    @Override
    public Member getMemberInfo(String id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Override
    public List<MembershipServiceRes> getMembershipServiceInfo(String id) {
        List<MembershipServiceRes> resList = new ArrayList<>();

        List<Membership> membershipList = membershipRepository.findAllByOrderByPriceMonthDesc();
        Membership bestMembership = membershipList.get(0);

        List<MemberService> memberServiceList = memberServiceRepository.findByMemberIdAndMembershipIsNotNullOrderByCreatedAtDesc(id);
        for (MemberService memberService : memberServiceList) {
            MembershipServiceRes res = new MembershipServiceRes();
            res.setId(memberService.getId());
            res.setMembership(memberService.getMembership());
            res.setStartDate(memberService.getStartDate());
            res.setExpiredDate(memberService.getEndDate());
            res.setAmount(memberService.getAmount());
            res.setStatus(memberService.getStatus());
            res.setIsBestPackage(Objects.equals(memberService.getMembership().getId(), bestMembership.getId()) ? 1 : 0);
            resList.add(res);
        }
        return resList;
    }

    @Override
    public List<PTServiceRes> getPTServiceInfo(String id) {
        List<PTServiceRes> resList = new ArrayList<>();
        List<MemberService> memberServiceList = memberServiceRepository.findByMemberIdAndPTServiceIsNotNullOrderByCreatedAtDesc(id);
        for (MemberService memberService : memberServiceList) {
            PTServiceRes res = new PTServiceRes();
            res.setId(memberService.getId());
            res.setService(memberService.getPersonalTrainerPackage());
            res.setStartDate(memberService.getStartDate());
            res.setExpiredDate(memberService.getEndDate());
            res.setTrainer(memberService.getCoach());
            res.setStatus(memberService.getStatus());

            WorkoutResult result = workoutResultRepository.findByMemberService(memberService);
            res.setHasResult(result != null ? 1 : 0);
            if (result != null) res.setResultId(result.getId());

            List<CoachSchedule> scheduleList = coachScheduleRepository.findByMemberServiceOrderByStartDateAsc(memberService);
            res.setSchedule(scheduleList);
            resList.add(res);
        }
        return resList;
    }

    @Override
    public List<MemberScheduleRes> getMemberSchedule(String id) {
        List<MemberScheduleRes> resList = new ArrayList<>();

        List<CoachSchedule> ptSchedule = coachScheduleRepository.findByMember(id);
        for (CoachSchedule schedule : ptSchedule) {
            MemberScheduleRes res = new MemberScheduleRes();
            res.setType("PT");
            res.setTitle(schedule.getTitle());
            res.setDescription(schedule.getDescription());
            res.setStartDate(schedule.getStartDate());
            res.setEndDate(schedule.getEndDate());
            res.setTrainer(schedule.getCoach());
            resList.add(res);
        }

        Member member = memberRepository.findById(id).orElseThrow();
        List<ClassMember> classSchedule = classMemberRepository.findByMember(member);
        for (ClassMember schedule : classSchedule) {
            MemberScheduleRes res = new MemberScheduleRes();
            res.setType("class");
            res.setTitle(schedule.getAClass().getTitle());
            res.setDescription(schedule.getAClass().getDescription());
            res.setStartDate(schedule.getAClass().getStartDate());
            res.setEndDate(schedule.getAClass().getEndDate());
            res.setAClass(schedule.getAClass());
            resList.add(res);
        }
        return resList;
    }

    @Override
    public void extendMembershipService(String id, ExtendMembershipReq request) throws ParseException {
        MemberService memberService = memberServiceRepository.findById(id).orElseThrow();
        Date newEndDate = dateFormat.parse(request.getNewEndDate());
        memberService.setEndDate(newEndDate);
        Double currentAmount = memberService.getAmount();
        memberService.setAmount(currentAmount + request.getCost());
        memberService.setStatus(checkDateStatus(memberService.getStartDate(), newEndDate));
        memberServiceRepository.save(memberService);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        Optional<Revenue> revenueOptional = revenueRepository.findByMonthAndYear(currentYear, currentMonth, memberService.getMember().getGym().getId());
        if (revenueOptional.isPresent()) {
            Revenue revenue = revenueOptional.get();
            Double currentMembershipRevenue = revenue.getMembershipRevenue();
            revenue.setMembershipRevenue(currentMembershipRevenue + request.getCost());
            revenueRepository.save(revenue);
        } else {
            Revenue newRevenueMonth = new Revenue();
            newRevenueMonth.setMonth(currentMonth);
            newRevenueMonth.setYear(currentYear);
            newRevenueMonth.setNonMemRevenue((double) 0);
            newRevenueMonth.setMembershipRevenue(request.getCost());
            newRevenueMonth.setPtServiceRevenue((double) 0);
            newRevenueMonth.setGym(memberService.getMember().getGym());
            newRevenueMonth.setCreatedAt(new Date());
            revenueRepository.save(newRevenueMonth);
        }
    }

    public static long getDaysBetween(Date startDate, Date endDate) {
        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(start, end) + 1; // Thêm 1 để bao gồm cả ngày bắt đầu và ngày kết thúc
    }

    @Override
    public void upgradeMembershipService(String id, UpgradeMembershipReq request) {
        MemberService memberService = memberServiceRepository.findById(id).orElseThrow();
        Date currentEndDate = memberService.getEndDate();
        LocalDate yesterday = LocalDate.now().minusDays(1);
        Date newEndDate = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        memberService.setEndDate(newEndDate);
        double pricePerDay = memberService.getMembership().getPriceMonth() / 30;
        long numDays = getDaysBetween(memberService.getStartDate(), newEndDate);
        memberService.setAmount(Math.round(pricePerDay * numDays * 100.0) / 100.0);
        String currentStatus = memberService.getStatus();
        memberService.setStatus("Expired");
        memberServiceRepository.save(memberService);

        MemberService newMemberService = new MemberService();
        newMemberService.setMember(memberService.getMember());
        Membership membership = membershipRepository.findById(request.getNewPackageId()).orElseThrow();
        newMemberService.setMembership(membership);
        newMemberService.setStartDate(new Date());
        newMemberService.setEndDate(currentEndDate);
        double priceDay = membership.getPriceMonth() / 30;
        Date today = new Date();
        long numDaysNew = getDaysBetween(today, currentEndDate);
        newMemberService.setAmount(Math.round(priceDay * numDaysNew * 100.0) / 100.0);
        newMemberService.setStatus(currentStatus);
        newMemberService.setIsSentMail(0);
        newMemberService.setCreatedAt(new Date());
        newMemberService.setUpdatedAt(new Date());
        memberServiceRepository.save(newMemberService);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        Optional<Revenue> revenueOptional = revenueRepository.findByMonthAndYear(currentYear, currentMonth, memberService.getMember().getGym().getId());
        if (revenueOptional.isPresent()) {
            Revenue revenue = revenueOptional.get();
            Double currentMembershipRevenue = revenue.getMembershipRevenue();
            revenue.setMembershipRevenue(currentMembershipRevenue + request.getCost());
            revenueRepository.save(revenue);
        } else {
            Revenue newRevenueMonth = new Revenue();
            newRevenueMonth.setMonth(currentMonth);
            newRevenueMonth.setYear(currentYear);
            newRevenueMonth.setNonMemRevenue((double) 0);
            newRevenueMonth.setMembershipRevenue(request.getCost());
            newRevenueMonth.setPtServiceRevenue((double) 0);
            newRevenueMonth.setGym(memberService.getMember().getGym());
            newRevenueMonth.setCreatedAt(new Date());
            revenueRepository.save(newRevenueMonth);
        }
    }

    @Override
    public void registerPTService(String id, RegisterPTServiceReq request) throws ParseException {
        Member member = memberRepository.findById(id).orElseThrow();

        MemberService memberService = new MemberService();
        memberService.setMember(member);
        PersonalTrainerPackage trainerPackage = personalTrainerPackageRepository.findById(request.getPackageId()).orElseThrow();
        memberService.setPersonalTrainerPackage(trainerPackage);
        memberService.setStartDate(dateFormat.parse(request.getStartDate()));
        memberService.setEndDate(dateFormat.parse(request.getEndDate()));
        memberService.setAmount(request.getCost());
        memberService.setStatus(checkDatePTServiceStatus(dateFormat.parse(request.getStartDate()), dateFormat.parse(request.getEndDate())));
        memberService.setCreatedAt(new Date());
        memberService.setUpdatedAt(new Date());
        memberServiceRepository.save(memberService);

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        Optional<Revenue> revenueOptional = revenueRepository.findByMonthAndYear(currentYear, currentMonth, member.getGym().getId());
        if (revenueOptional.isPresent()) {
            Revenue revenue = revenueOptional.get();
            Double currentPTRevenue = revenue.getPtServiceRevenue();
            revenue.setPtServiceRevenue(currentPTRevenue + request.getCost());
            revenueRepository.save(revenue);
        } else {
            Revenue newRevenueMonth = new Revenue();
            newRevenueMonth.setMonth(currentMonth);
            newRevenueMonth.setYear(currentYear);
            newRevenueMonth.setNonMemRevenue((double) 0);
            newRevenueMonth.setMembershipRevenue((double) 0);
            newRevenueMonth.setPtServiceRevenue(request.getCost());
            newRevenueMonth.setGym(member.getGym());
            newRevenueMonth.setCreatedAt(new Date());
            revenueRepository.save(newRevenueMonth);
        }
    }

    @Override
    public void selectPT(String id, SelectPTReq request) {
        MemberService memberService = memberServiceRepository.findById(id).orElseThrow();
        Coach coach = coachRepository.findById(request.getCoachId()).orElseThrow();
        memberService.setCoach(coach);
        memberServiceRepository.save(memberService);
    }

    @Override
    public void addWorkoutResult(String id, WorkoutResultReq request) {
        MemberService memberService = memberServiceRepository.findById(id).orElseThrow();
        WorkoutResult workoutResult = new WorkoutResult();
        workoutResult.setMemberService(memberService);
        workoutResult.setGym(memberService.getMember().getGym());
        workoutResult.setNumWeeks(request.getNumWeeks());
        workoutResult.setImageUrl(request.getImageUrl());
        workoutResult.setPreIssues(request.getPreIssues());
        workoutResult.setShareContent(request.getShareContent());
        workoutResult.setDescription(request.getDescription());
        workoutResult.setMeasurement(request.getMeasurement());
        workoutResult.setProgramDescription(request.getProgramDescription());
        workoutResult.setNutritionPlan(request.getNutritionPlan());
        workoutResult.setCreatedAt(new Date());
        workoutResult.setUpdatedAt(new Date());
        workoutResultRepository.save(workoutResult);
    }

    @Override
    public void editWorkoutResult(String id, WorkoutResultReq request) {
        WorkoutResult workoutResult = workoutResultRepository.findById(id).orElseThrow();
        workoutResult.setImageUrl(request.getImageUrl());
        workoutResult.setPreIssues(request.getPreIssues());
        workoutResult.setShareContent(request.getShareContent());
        workoutResult.setDescription(request.getDescription());
        workoutResult.setMeasurement(request.getMeasurement());
        workoutResult.setProgramDescription(request.getProgramDescription());
        workoutResult.setNutritionPlan(request.getNutritionPlan());
        workoutResult.setUpdatedAt(new Date());
        workoutResultRepository.save(workoutResult);
    }

    @Override
    public GetListResultRes getListResults(String gymId, String gender, int age, int minNumWeeks, int maxNumWeeks, String keyword, int page) {
        Pageable pageable = PageRequest.of(page - 1, 9);
        List<WorkoutResult> listItem = workoutResultRepository.getListExceptFilterAge(gymId, gender, minNumWeeks, maxNumWeeks, keyword);
        if (age != 0) {
            listItem = listItem.stream().filter(workoutResult -> calculateAge(workoutResult.getMemberService().getMember().getDob()) >= age).toList();
        }
        int numItem = listItem.size();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listItem.size());
        Page<WorkoutResult> resultPage = new PageImpl<>(listItem.subList(start, end), pageable, listItem.size());

        return GetListResultRes.builder()
                .listItem(resultPage.getContent())
                .numItem(numItem)
                .build();
    }

    public int calculateAge(Date dob) {
        LocalDate birthDate = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    @Override
    public WorkoutResult getWorkoutResult(String id) {
        return workoutResultRepository.findById(id).orElseThrow();
    }

    @Override
    public List<WorkoutResult> getWorkoutResultHomePage() {
        List<WorkoutResult> workoutResults = workoutResultRepository.findAll();
        Collections.shuffle(workoutResults);
        if (workoutResults.size() > 6) {
            workoutResults = workoutResults.subList(0, 6);
        }
        return workoutResults;
    }

    @Override
    public void registerTrial(TrialRegistrationReq request) {
        TrialRegistration trialRegistration = new TrialRegistration();
        trialRegistration.setName(request.getName());
        trialRegistration.setPhone(request.getPhone());
        Gym gym = gymRepository.findById(request.getGymId()).orElseThrow();
        trialRegistration.setGym(gym);
        trialRegistration.setTimeContact(request.getTimeContact());
        trialRegistration.setStatusContact("Uncontacted");
        trialRegistration.setStatusApprove("Pending");
        trialRegistration.setCreatedAt(new Date());
        trialRegistration.setUpdatedAt(new Date());
        trialRegistrationRepository.save(trialRegistration);
    }

    @Override
    public List<WorkoutResult> getOtherResult(String id) {
        List<WorkoutResult> workoutResults = workoutResultRepository.findAll();
        List<WorkoutResult> response = new ArrayList<>();
        workoutResults.removeIf(workoutResult -> workoutResult.getId().equals(id));
        Collections.shuffle(workoutResults);
        if (workoutResults.size() > 3) response = workoutResults.subList(0, 3);
        else response = workoutResults;
        return response;
    }

    private static final String PAY_COMMAND = "pay";
    private static final String VERSION = "2.1.0";

    @Value("${vnpay.redirect.url}")
    String vnPayRedirectUrl;

    @Override
    public GetPayUrlRes generateVNPayUrl(Long money) {
        try {
            String vnp_OrderInfo = "Thanh toan dich vu hoi vien";
            String orderType = "other";
            String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
            String vnp_IpAddr = VNPayConfig.getIpAddress();
            String vnp_TmnCode = VNPayConfig.vnp_TmnCode;

            Long amount = money * 100;
            Map<Object, Object> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", VERSION);
            vnp_Params.put("vnp_Command", PAY_COMMAND);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");
            String bank_code = new String();
            if (!bank_code.isEmpty()) {
                vnp_Params.put("vnp_BankCode", bank_code);
            }
            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
            vnp_Params.put("vnp_OrderType", orderType);

            String locate = new String();
            if (locate != null && !locate.isEmpty()) {
                vnp_Params.put("vnp_Locale", locate);
            } else {
                vnp_Params.put("vnp_Locale", "vn");
            }
            vnp_Params.put("vnp_ReturnUrl", vnPayRedirectUrl);
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());

            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
            String fullName = "Do Tung Lam";
            if (!fullName.isEmpty()) {
                int idx = fullName.indexOf(' ');
                String firstName = fullName.substring(0, idx);
                String lastName = fullName.substring(fullName.lastIndexOf(' ') + 1);
                vnp_Params.put("vnp_Bill_FirstName", firstName);
                vnp_Params.put("vnp_Bill_LastName", lastName);
            }
            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.secretKey, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
            return GetPayUrlRes.builder().url(paymentUrl).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
