package com.example.gms_backend.service.serviceImpl;

import com.example.gms_backend.dto.request.GymReq;
import com.example.gms_backend.dto.response.*;
import com.example.gms_backend.entity.*;
import com.example.gms_backend.repository.*;
import com.example.gms_backend.service.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
    private final GymRepository gymRepository;
    private final MemberServiceRepository memberServiceRepository;
    private final NonMemberCustomerRepository nonMemberCustomerRepository;
    private final EquipmentRepository equipmentRepository;
    private final CoachRepository coachRepository;
    private final EquipmentRepairRepository equipmentRepairRepository;
    private final RevenueRepository revenueRepository;
    private final MembershipRepository membershipRepository;
    private final MemberRepository memberRepository;
    private final ClassRepository classRepository;

    @Override
    public List<Gym> getListGyms() {
        return gymRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Gym> getListActiveGyms() {
        return gymRepository.findByStatusOrderByCreatedAtDesc("Active");
    }

    @Override
    public Gym getGym(String id) {
        return gymRepository.findById(id).orElseThrow();
    }

    @Override
    public void addGym(GymReq request) {
        Gym newGym = new Gym();
        newGym.setName(request.getName());
        newGym.setAddress(request.getAddress());
        newGym.setDescription(request.getDescription());
        newGym.setPhone(request.getPhone());
        newGym.setThumbnail(request.getThumbnail());
        newGym.setOperatingTime(request.getOperatingTime());
        newGym.setListImage(request.getListImage());
        newGym.setAmenity(request.getAmenity());
        newGym.setStatus("Active");
        newGym.setCreatedAt(new Date());
        newGym.setUpdatedAt(new Date());
        gymRepository.save(newGym);
    }

    @Override
    public void editGym(String id, GymReq request) {
        Gym gym = gymRepository.findById(id).orElseThrow();
        gym.setName(request.getName());
        gym.setAddress(request.getAddress());
        gym.setDescription(request.getDescription());
        gym.setPhone(request.getPhone());
        gym.setThumbnail(request.getThumbnail());
        gym.setOperatingTime(request.getOperatingTime());
        gym.setListImage(request.getListImage());
        gym.setAmenity(request.getAmenity());
        gym.setStatus(request.getStatus());
        gym.setUpdatedAt(new Date());
        gymRepository.save(gym);
    }

    @Override
    public GeneralDataDashboardRes getGeneralDashboardData(String gymId) {
        int numMembers = memberServiceRepository.getNumAvailableMember(gymId);
        int numNonMemCustomers = nonMemberCustomerRepository.countTotalNonMemCustomer(gymId);
        int numEquipment = equipmentRepository.getTotalQuantityEquipment(gymId);
        int numCoaches = coachRepository.countTotalCoach(gymId);
        Double revenue = revenueRepository.getTotalRevenue(gymId);
        Double totalEquipmentPurchaseCost = equipmentRepository.getTotalCostPurchaseEquipment(gymId);
        Double totalEquipmentRepairCost = equipmentRepairRepository.getTotalCostRepairEquipment(gymId);
        Double profit = revenue - totalEquipmentPurchaseCost - totalEquipmentRepairCost;

        List<DataLabelValueRes> numMembersByMemPackage = new ArrayList<>();
        List<Membership> memberships = membershipRepository.findAllByOrderByPriceMonthAsc();
        for (Membership membership : memberships) {
            DataLabelValueRes data = new DataLabelValueRes();
            data.setLabel(membership.getName());
            int numMemberByMembershipPackage = memberServiceRepository.getNumMemberByMembershipPackage(gymId, membership.getId());
            data.setValue(numMemberByMembershipPackage);
            numMembersByMemPackage.add(data);
        }

        List<DataLabelValueRes> numCoachesByLevel = new ArrayList<>();
        List<String> levels = new ArrayList<>(Arrays.asList("Senior coach", "Junior coach"));
        for (String level : levels) {
            DataLabelValueRes data = new DataLabelValueRes();
            data.setLabel(level);
            int value = coachRepository.getNumCoachByLevel(gymId, level);
            data.setValue(value);
            numCoachesByLevel.add(data);
        }

        return GeneralDataDashboardRes.builder()
                .numMembers(numMembers)
                .numNonMemCustomers(numNonMemCustomers)
                .numEquipment(numEquipment)
                .numCoaches(numCoaches)
                .revenue(revenue)
                .profit(profit)
                .numMembersByMemPackage(numMembersByMemPackage)
                .numCoachesByLevel(numCoachesByLevel)
                .totalEquipmentPurchaseCost(totalEquipmentPurchaseCost)
                .totalEquipmentRepairCost(totalEquipmentRepairCost)
                .build();
    }

    @Override
    public List<Map<String, Object>> calculateMonthlyGrowthRate(String gymId, int year) {
        List<Map<String, Object>> growthRates = new ArrayList<>();
        int previousMonthMembers = 0;

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        for (int month = 1; month <= 12; month++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[month - 1]);

            if (year > currentYear || (year == currentYear && month > currentMonth)) {
                monthData.put("growthRate", 0.0);
                growthRates.add(monthData);
                continue;
            }

            int currentMonthMembers = memberRepository.countNewMembersByMonth(gymId, year, month);

            // Nếu là tháng đầu tiên của năm, chỉ cần đặt giá trị currentMonthMembers mà không tính toán tỷ lệ tăng trưởng
            if (month == 1) {
                previousMonthMembers = currentMonthMembers;
                monthData.put("growthRate", 0);
                growthRates.add(monthData);
                continue;
            }

            // Nếu previousMonthMembers là 0, không thể tính toán tỷ lệ tăng trưởng
            if (previousMonthMembers == 0) {
                monthData.put("growthRate", 0);
            } else {
                double growthRate = ((double) (currentMonthMembers - previousMonthMembers) / previousMonthMembers) * 100;
                growthRate = Math.round(growthRate * 10.0) / 10.0;
                monthData.put("growthRate", growthRate);
            }

            growthRates.add(monthData);
            previousMonthMembers = currentMonthMembers;
        }

        return growthRates;
    }

    @Override
    public GetListMemberRes getNewMembersToday(String gymId, int page) {
        Pageable pageable = PageRequest.of(page, 5);
        List<MemberInfoRes> listItem = new ArrayList<>();
        Date today = new Date();

        List<Member> memberList = memberRepository.findNewMembersToday(today, gymId);
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
    public List<Map<String, Object>> calculateNewMemberByMonth(String gymId, int year) {
        List<Map<String, Object>> response = new ArrayList<>();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int month = 1; month <= 12; month++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[month - 1]);
            int value = memberRepository.countNewMembersByMonth(gymId, year, month);
            monthData.put("value", value);
            response.add(monthData);
        }
        return response;
    }

    @Override
    public List<Map<String, Object>> calculateNonMemCustomerByMonth(String gymId, int year) {
        List<Map<String, Object>> response = new ArrayList<>();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int month = 1; month <= 12; month++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[month - 1]);
            int value = nonMemberCustomerRepository.countNonMemCustomersByMonth(gymId, year, month);
            monthData.put("value", value);
            response.add(monthData);
        }
        return response;
    }

    @Override
    public List<Map<String, Object>> calculateRevenueByMonth(String gymId, int year) {
        List<Map<String, Object>> response = new ArrayList<>();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int month = 1; month <= 12; month++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[month - 1]);

            Double membershipRevenue = revenueRepository.getMembershipRevenueByMonth(gymId, year, month);
            monthData.put("membershipRevenue", membershipRevenue);

            Double ptRevenue = revenueRepository.getPTServiceRevenueByMonth(gymId, year, month);
            monthData.put("ptRevenue", ptRevenue);

            Double nonMemCustomerRevenue = revenueRepository.getNonMemCustomerRevenueByMonth(gymId, year, month);
            monthData.put("nonMemCustomerRevenue", nonMemCustomerRevenue);

            Double totalRevenue = revenueRepository.getTotalRevenueByMonth(gymId, year, month);
            monthData.put("totalRevenue", totalRevenue);

            response.add(monthData);
        }
        return response;
    }

    @Override
    public List<Map<String, Object>> calculateEquipmentRepairCostByMonth(String gymId, int year) {
        List<Map<String, Object>> response = new ArrayList<>();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int month = 1; month <= 12; month++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[month - 1]);
            Double value = equipmentRepairRepository.getCostRepairEquipmentByMonth(gymId, year, month);
            monthData.put("cost", value);
            response.add(monthData);
        }
        return response;
    }

    @Override
    public GetListCoachDashboardRes getCoachesRanking(String gymId, int page) {
        int numItem = coachRepository.countTotalCoach(gymId);
        Pageable pageable = PageRequest.of(page, 3);
        List<DataCoachDashboardRes> listItem = new ArrayList<>();

        List<Coach> coaches = coachRepository.getListTotalActiveCoach(gymId);
        for (Coach coach : coaches) {
            DataCoachDashboardRes infoCoach = new DataCoachDashboardRes();
            infoCoach.setId(coach.getId());
            infoCoach.setCode(coach.getCode());
            infoCoach.setName(coach.getName());
            infoCoach.setLevel(coach.getLevel());
            int numMembersTrained = memberServiceRepository.getNumMemberOfCoach(coach.getId());
            infoCoach.setNumMembersTrained(numMembersTrained);
            int numClassesTaught = classRepository.getNumClassesOfCoach(coach.getId());
            infoCoach.setNumClassesTaught(numClassesTaught);
            listItem.add(infoCoach);
        }

        listItem.sort((o1, o2) -> {
            int total1 = o1.getNumMembersTrained() + o1.getNumClassesTaught();
            int total2 = o2.getNumMembersTrained() + o2.getNumClassesTaught();
            return Integer.compare(total2, total1);
        });

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), listItem.size());
        Page<DataCoachDashboardRes> coachInfoPageable = new PageImpl<>(listItem.subList(start, end), pageable, listItem.size());

        return GetListCoachDashboardRes.builder()
                .listItem(coachInfoPageable.getContent())
                .numItem(numItem)
                .build();
    }
}
