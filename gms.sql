-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 26, 2024 lúc 12:37 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `gms`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `articles`
--

CREATE TABLE `articles` (
  `id` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `content` mediumtext DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `is_publish` int(11) DEFAULT NULL,
  `published_at` datetime(6) DEFAULT NULL,
  `tags` text DEFAULT NULL,
  `thumbnail` text DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `view` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `articles`
--

INSERT INTO `articles` (`id`, `category`, `content`, `created_at`, `is_publish`, `published_at`, `tags`, `thumbnail`, `title`, `updated_at`, `view`) VALUES
('37a44359-dbef-4936-b539-bff78467f56e', 'Workout Knowledge', '<p>Long before steroids, men were using full body routines to carve out massive and strong natural physiques. This article presents 5 effective workouts!</p><p>It\'s time for a challenge. I want you to put aside everything you know about training and try something new. And here\'s the interesting part...this \"new\" form of training isn\'t new at all. In fact, it\'s old as in old school.</p><p>Believe it or not, in a time not so long ago - before steroids invaded the muscle building scene - lifters trained using full body approaches. Yes, that\'s right. Full body training. In fact, full body training used to be the accepted norm. Then things changed.</p><p>Now I know what you\'re thinking: the change from full body routines to training splits must have been a needed evolution. It was! You\'re correct. Steroids entered the scene, and bodybuilders found they could train longer and recover more quickly. So steroid users began experimenting with split training.</p><p>Around this time, publisher Joe Weider started to feature the elaborate split training routines of the largest steroid users on the planet in his magazines. As a result, the science and practices of natural bodybuilding training was left behind and nearly forgotten. For the next 40 years or so, lifters opened magazines to (only) find HUGE Mr. Olympia and his six day double split routine. There was rarely any serious talk of full body training.</p><p>In this article I will turn back the hands of time and introduce you to some training routines that were once the norm for natural bodybuilders. It is my hope that you won\'t dismiss them simply because they are old school. Consider the fact that some of the biggest naturals of all time trained using full body routines - Reg Park, John Grimek and Steve Reeves. Full body routines are not outdated. Every natural bodybuilder should take them seriously. A full body routine might not be the best routine for you, but as they say...you never know until you try.</p><h2>Full&nbsp;Body Training Notes</h2><p>Full body routines are different than training splits in several ways. You will be hitting every major muscle group on each training day, either directly or indirectly, but you will be performing fewer daily sets per bodypart. Full body training can be very taxing, simply because you are hammering your entire body. Make sure you resist the urge to add in more training days.  <span style=\"background-color: rgb(254, 254, 254); color: rgb(51, 51, 51);\">Here are some other things you should know about full body training:</span></p><ul><li><strong>Training Frequency.</strong> Most full body routines require 3 weekly workouts, generally on Monday, Wednesday and Friday. You never want to perform full body workouts on back to back days.</li><li><strong>Exercise Selection.</strong> Full body routines focus on the use of heavy compound lifts. By getting strong on several major lifts, you will be stimulating muscle growth without the need to use numerous exercises for each body part.</li><li><strong>Minor Muscle Groups.</strong> In general, you will not find an excess of direct work for minor muscle groups. You must resist the urge to feel like a full body workout isn\'t effective because you aren\'t getting in enough direct work for rear delts, forearms, abs, etc. You are casting a broad net by working the entire body with compound lifts 3 times each week. This approach WILL cause minor muscle groups to respond.</li><li><strong>Mental Connection.</strong> Some trainees struggle making the mental connection with full body training. For some, seeing everyone around you engaged in split training can make you wonder if you\'re truly doing the right thing. Remember that just because full body workouts are old school doesn\'t mean that the lifters didn\'t have a clue about what they were doing. Full body routines were used effectively for decades upon decades.</li></ul><p><img src=\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fimage_1719501051822.png?alt=media&token=2c863c01-cdee-44c4-a9fe-69813e0fff22\"></p>', '2024-06-27 22:10:54.000000', 1, '2024-07-09 14:21:42.000000', 'Full Body/Workout/Old School Training/Natural Bodybuilding', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2FScreenshot%202024-06-27%20220733.png?alt=media&token=7266135a-9c22-4dfa-8c7a-805cc6edd00e', 'Forget Steroids: 5 Full Body Workouts For Serious Gains', '2024-07-09 14:21:42.000000', 10),
('afe42cd2-6ba2-4ed4-ae83-5e4c93a0bf05', 'Health Guides', '<p>Is your goal to get “see your abs” lean? Would you like to fill out your t-shirt but still have a waspish waist? Do you want to look like you’re flexing without actually flexing?</p><p>To get that jacked you need to get lean, and I mean LEAN. 10% to be exact. Forget for a moment the braggarts who claim single digit body fat levels. Yes, there are some in this world who walk around at 8, 6, even 4% body fat levels, but not many. If you’re 10% you’re pretty flippin lean. So let’s see how to get there.</p><h2>Cycle your diet</h2><p>Yes, what is an article about getting lean without mentioning diet? Abs are made in the kitchen, right? Well, yes, to an extent. But diet is still a key factor in the making of a leaner you. To get to an extreme level of said leanness takes a strict habit of meal planning, disciplined adherence to that plan and the wherewithal to listen to your body and adjust when needed.</p><p>Carb cycling, although seen somewhat archaic in these times of the fasting fad, is still a viable, effective option for cutting body fat and staying sane in the process. Cycling your carbohydrate intake normally calls for several days in the red and then a day or two of a surplus.</p><p>This process cuts calories down for a limited time forcing your body to burn fat, even at rest. Once your body starts to get wise and tries to slow down your metabolism to conserve energy due to the lack of calories you jack up the carb intake and give it a much-needed surge to kick start your fat-burning furnace once again.</p><ul><li>Start by choosing which days will be high and low carb days. For example, lower body training days may be good for high carb periods, other training days could be for low to moderate carb levels and off days could be reserved for very low carb days.</li><li>In the beginning it will be difficult to predict what your exact levels should be for each day so here is a good starting point: For low days go with .5 to .75 grams of carbs per pound of bodyweight, for moderate days go with 1 to 1.25 grams per pound and for high days aim for around 2 grams per pound.</li><li>Be sure you are getting in at least 1 gram of protein per pound of bodyweight. This can realistically be increased to 1.5 as your diet progresses.</li><li>Healthy fats should consist of around 20-30% of your total daily calories. These fats will come in handy on those crazy, low carb times when you need some extra fuel to get you through your workouts.</li></ul><p><img src=\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fimage_1719487911001.png?alt=media&amp;token=a5394173-b3e9-4947-bec0-f57333921aae\"></p>', '2024-06-27 17:06:48.000000', 1, '2024-06-27 19:37:37.000000', 'Lean Body/Carb Cycling/Resistance Training', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2FScreenshot%202024-06-27%20165952.png?alt=media&token=d69f33a5-9be5-4107-8b51-4b4ef9d2ba98', 'Shredded! A Complete Guide To Getting to 10% Body Fat', '2024-06-27 19:37:37.000000', 92),
('f5a2bce8-dea4-4086-aa8b-fce2a454e8a5', 'Workout Knowledge', '<p>Your body type can influence how you respond to different types of workouts and diet plans. This guide helps you understand your body type (ectomorph, mesomorph or endomorph) and how you can structure your workout and diet for success.</p><p>When I first got into the muscle building scene I was overwhelmed by the amount of different training programs, bodybuilding supplements, diets, articles and information there was out there. There were so many conflicting diets and training programs available and I had no idea what I “should” be doing. The result of this was about 6 months in the gym with little gains and almost no motivation to workout anymore.</p><p>I was at a complete loss and about to throw in the towel and give up. Then a guy in the gym gave me a magazine and told me to read the article in there about body types. So I did and it opened my eyes up to the reason why I wasn’t making any gains in the gym.</p><p>I am a true ectomorph (classic hardgainer) and my bodyweight was 60.2kg (132.5lbs) when I first walked into a gym. I had no idea about body types back then. I assumed (like most beginners do) that the more I worked out the bigger I would get. Thinking that “more was better” I started following a program designed for an elite bodybuilder. This resulted in gains of about 1.7kg in 6 months.</p><p>After reading the body type article in that magazine I started to understand more about how my body type worked, my metabolism, and gaining weight. Being an ectomorph I need to focus on calorie intake, long rest periods, and minimum cardio. It was only then I started making some real gains and I’ve never looked back.</p><p>So it’s important to be able to identify and understand your body type. Different body types require different training methods and diet plans. So listed below are the 3 male body types: ectomorph, mesomorph and endomorph, along with their characteristics.</p><p><img src=\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fimage_1719500797413.png?alt=media&token=9e1a7a16-70d9-4ad6-ab1c-778157ecd3d5\"></p><p><span style=\"background-color: rgb(254, 254, 254); color: rgb(51, 51, 51);\">Image courtesy of&nbsp;</span><a href=\"http://www.getthefacts.health.wa.gov.au/\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"background-color: rgb(254, 254, 254); color: rgb(0, 85, 153);\">Govt. of Western Aust. Dept. of Health</a></p>', '2024-06-27 22:06:39.000000', 1, '2024-07-11 11:57:03.000000', 'Body Type Training/Ectomorph Workout Plan', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2FScreenshot%202024-06-27%20220400.png?alt=media&token=c58cdb14-201c-42d2-bf25-db0342147706', 'Your Body Type - Ectomorph, Mesomorph or Endomorph?', '2024-07-11 11:57:03.000000', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `benefits`
--

CREATE TABLE `benefits` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `benefits`
--

INSERT INTO `benefits` (`id`, `created_at`, `description`, `updated_at`) VALUES
('1643631b-76c3-4ada-bcbc-19af7e9d436d', '2024-06-28 17:07:58.000000', 'Access to sauna and steam room', '2024-08-12 15:52:48.000000'),
('2d6d5691-b474-43c2-899f-1cce12d3c420', '2024-06-28 17:07:28.000000', 'Unlimited towel service', '2024-06-28 17:07:28.000000'),
('40df6d9d-d2b0-4589-a2eb-81ef0d8687b8', '2024-06-28 17:06:43.000000', 'Fitness consultation', '2024-06-28 17:06:43.000000'),
('7d671633-3482-4a79-ae7e-6b8767109574', '2024-06-28 17:07:03.000000', 'Participate in group classes', '2024-06-28 17:07:03.000000'),
('897a0c8b-6978-45d4-b99c-dda4530c242c', '2024-06-28 17:07:16.000000', 'Personalized workout plan', '2024-06-28 17:07:16.000000'),
('8e644393-4ac8-4c2f-b869-2575f93fd829', '2024-06-28 17:06:23.000000', 'Access to gym facilities', '2024-06-28 17:06:23.000000'),
('a6608940-5fe4-40d2-85a4-8cbb011c71ed', '2024-06-28 17:07:46.000000', 'Discounts on supplements', '2024-06-28 17:07:46.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand_infos`
--

CREATE TABLE `brand_infos` (
  `id` varchar(255) NOT NULL,
  `bank_accounts` longtext DEFAULT NULL,
  `business_address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `day_pass_fee` double DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hotline` varchar(255) DEFAULT NULL,
  `image_slider` longtext DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `media_link` mediumtext DEFAULT NULL,
  `name_brand` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `brand_infos`
--

INSERT INTO `brand_infos` (`id`, `bank_accounts`, `business_address`, `created_at`, `day_pass_fee`, `email`, `hotline`, `image_slider`, `logo`, `media_link`, `name_brand`, `tax_code`, `updated_at`) VALUES
('2138aca9-4a6e-4ff7-a9f1-ec4f5b23253e', '[{\"bank\":\"VIETCOMBANK\",\"accNumber\":\"1018461684\",\"owner\":\"DO VU TUNG LAM\",\"qrCode\":\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1715419359221.png?alt=media&token=47d2d8a1-c9be-4721-8f4a-7afd7d6b3ab4\"},{\"bank\":\"TECHCOMBANK\",\"accNumber\":\"1077868572\",\"owner\":\"DO VU TUNG LAM\",\"qrCode\":\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1715419411764.png?alt=media&token=abd3d260-b009-48e7-9824-f0cfa07a2254\"},{\"bank\":\"BIDV\",\"accNumber\":\"1054684431\",\"owner\":\"DO VU TUNG LAM\",\"qrCode\":\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1715419440389.png?alt=media&token=125750fa-6e45-4b5a-a86c-b49b2e3104cb\",\"selectedQRFile\":null}]', '123 Oak Street, Springfield, Massachusetts, United States', '2024-06-27 22:38:28.000000', 6, 'contact@eaglefit.com', '18001410', '[\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-823sl-2294361.jpg?alt=media&token=2b322779-7e25-41ac-b9d2-f0c266d29201\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-pixabay-414029.jpg?alt=media&token=60058f41-56ba-477f-9287-da86e9c48d5b\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-pixabay-416778.jpg?alt=media&token=d3ad141b-0948-496c-bac0-28e1ab83ce82\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-zakaria-2827392.jpg?alt=media&token=98ed9322-b39d-4a47-9cd5-55653c1e0250\"]', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Flogo.png?alt=media&token=f9d1cb36-afd8-4d54-a555-d35b42ae7177', '{\"facebook\":\"https://www.facebook.com/dotunglam14\",\"youtube\":\"https://www.youtube.com/\",\"instagram\":\"https://www.youtube.com/\",\"twitter\":\"\",\"tiktok\":\"https://www.youtube.com/\",\"pinterest\":\"\",\"linkedin\":\"\"}', 'Eaglefit', '0807530912', '2024-06-27 22:38:28.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes`
--

CREATE TABLE `classes` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `current_participants` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `max_participants` int(11) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `coach_id` varchar(255) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `classes`
--

INSERT INTO `classes` (`id`, `code`, `created_at`, `current_participants`, `description`, `end_date`, `max_participants`, `start_date`, `title`, `updated_at`, `category_id`, `coach_id`, `gym_id`) VALUES
('1a42b866-c79d-4773-8e96-1c6879492669', '392694', '2024-07-03 23:44:31.000000', 0, 'Class for old member', '2024-07-05 15:00:00.000000', 15, '2024-07-05 14:00:00.000000', 'Old Mem Class', '2024-07-03 23:44:31.000000', 'd716ec98-9459-4434-ac98-5f97afdf7c0d', '801f6d1d-d7c7-4767-b285-43bafc2d686c', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('46cb4057-9bd3-4542-8069-59355471bf5c', '536310', '2024-07-03 23:39:02.000000', 0, 'Training with ketchbell', '2024-07-06 15:00:00.000000', 30, '2024-07-06 13:30:00.000000', 'Ketchbell Workout', '2024-07-03 23:39:02.000000', 'd716ec98-9459-4434-ac98-5f97afdf7c0d', 'a1718422-0774-4079-b394-d24467bde6bf', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('67d0b4dc-2e99-4d79-a670-d2f85fd4f247', '955692', '2024-07-03 22:21:17.000000', 0, 'Strength Training class conducted by Alex Tuner.', '2024-07-05 10:00:00.000000', 22, '2024-07-05 08:45:00.000000', 'Strength Training Class', '2024-07-04 00:41:59.000000', 'd716ec98-9459-4434-ac98-5f97afdf7c0d', '6769c773-9f37-48c0-aa63-d3aab5657b0c', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('8f805ad2-e711-41bb-826a-f222ced812ec', '256948', '2024-07-11 11:53:39.000000', 0, 'Dumbbells', '2024-07-12 09:45:00.000000', 30, '2024-07-12 08:00:00.000000', 'Training with dumbbells', '2024-07-11 11:53:39.000000', 'd716ec98-9459-4434-ac98-5f97afdf7c0d', '6769c773-9f37-48c0-aa63-d3aab5657b0c', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('9387216e-ba2c-450d-bf69-be3f3d06ddf8', '491736', '2024-07-03 23:36:10.000000', 0, 'Advanced Strength Training class', '2024-07-06 10:15:00.000000', 18, '2024-07-06 08:30:00.000000', 'Strength Training Advanced', '2024-07-03 23:36:10.000000', 'd716ec98-9459-4434-ac98-5f97afdf7c0d', '801f6d1d-d7c7-4767-b285-43bafc2d686c', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('cd0b26c9-b2a5-43ea-a2b9-f20c6363b3d7', '539279', '2024-07-11 11:51:31.000000', 1, 'Class for beginners', '2024-07-11 16:30:00.000000', 15, '2024-07-11 15:00:00.000000', 'Class for Beginners', '2024-07-11 11:51:31.000000', 'd716ec98-9459-4434-ac98-5f97afdf7c0d', '72bc5b9d-949b-45c8-a210-690637382ee8', '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `class_categories`
--

CREATE TABLE `class_categories` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `class_categories`
--

INSERT INTO `class_categories` (`id`, `created_at`, `name`, `updated_at`) VALUES
('05c327f6-e53f-443f-b23a-383ba3a7ddad', '2024-07-03 17:59:17.000000', 'Cardio', '2024-07-03 17:59:17.000000'),
('20f30950-1e85-44a9-a2c0-01665f35d541', '2024-07-03 17:59:11.000000', 'Yoga', '2024-07-03 18:01:42.000000'),
('474120a3-80c4-4fce-8344-ddb353093843', '2024-07-03 17:59:23.000000', 'Boxing', '2024-07-04 23:22:23.000000'),
('947ff5fa-79f5-48a7-a2cf-9518dacc7c19', '2024-07-03 17:59:07.000000', 'GroupX', '2024-07-03 17:59:07.000000'),
('d716ec98-9459-4434-ac98-5f97afdf7c0d', '2024-07-03 17:59:30.000000', 'Strength Training', '2024-07-04 22:23:10.000000'),
('f27116f7-c2d1-4068-b011-a5b7e3002c48', '2024-07-03 17:58:57.000000', 'Weight Loss/Fat Burn', '2024-07-03 17:58:57.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `class_members`
--

CREATE TABLE `class_members` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL,
  `member_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `class_members`
--

INSERT INTO `class_members` (`id`, `created_at`, `updated_at`, `class_id`, `member_id`) VALUES
('02c9fef2-f442-4488-b79a-3d12c663ae94', '2024-07-11 11:51:43.000000', '2024-07-11 11:51:43.000000', 'cd0b26c9-b2a5-43ea-a2b9-f20c6363b3d7', 'c614dfc2-28d1-463b-8db8-503d5411a4cb');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `coaches`
--

CREATE TABLE `coaches` (
  `id` varchar(255) NOT NULL,
  `achievements` text DEFAULT NULL,
  `certification` text DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `experience` text DEFAULT NULL,
  `expertise` text DEFAULT NULL,
  `image_url` text DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `coaches`
--

INSERT INTO `coaches` (`id`, `achievements`, `certification`, `code`, `created_at`, `description`, `dob`, `email`, `experience`, `expertise`, `image_url`, `level`, `name`, `phone`, `status`, `updated_at`, `gym_id`) VALUES
('6769c773-9f37-48c0-aa63-d3aab5657b0c', '<ul><li>2019 Wellness Coach of the Year (National Wellness Association)</li><li>Helped 75+ clients improve their fitness and well-being in the past 4 years</li></ul>', '<ul><li>Certified Personal Trainer (ACSM)</li><li>Certified Yoga Instructor (200-hour RYT)</li></ul>', 'PT6205', '2024-06-29 15:33:44.000000', '<p>Personality: Inspiring, adaptable, friendly, encouraging, knowledgeable</p><p>Coaching Philosophy: Fitness is a balance between mind, body, and soul. It\'s about creating harmony in your life through physical activity and healthy habits. My philosophy is to empower clients to find their own strength and resilience through personalized training and holistic wellness strategies.</p><p>Coaching Approach: I take a holistic approach to fitness, integrating physical training with mental wellness practices. I work closely with my clients to understand their goals, limitations, and motivations, creating a supportive environment where they can thrive. My sessions include a mix of strength, flexibility, and mindfulness techniques to promote overall well-being.</p>', '1993-01-26 00:00:00.000000', 'alex.tuner@example.com', '<p>4 years as a wellness coach, 6 years of personal training</p>', '<ul><li>Specializes in yoga and Pilates</li><li>Expertise in holistic wellness and stress management</li><li>Skilled in creating balanced training programs that include strength, flexibility, and mindfulness</li></ul>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-olly-3931125.jpg?alt=media&token=3dc14085-8404-479c-a481-71b9b0cd4413', 'Senior coach', 'Alex Tuner', '0384916161', 'Active', '2024-06-29 17:30:00.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('72bc5b9d-949b-45c8-a210-690637382ee8', '<p>Completed numerous endurance events including marathons and Ironman triathlons</p>', '<p>Certified Personal Trainer (NASM)</p>', 'PT5412', '2024-07-09 14:25:08.000000', '<p>Personality: calm, disciplined, empathetic, perceptive, passionate about work</p><p>Coaching Philosophy: For me, only unwavering determination can truly transform people. There is no \"metamorphosis\" for those who are lazy about training. Think more, change more. Take care of yourself so that you can take care of your loved ones.&lt;/p&gt;&lt;p&gt;Coaching Approach: I see myself not just as a trainer, but as a companion, a \"spotter\" for my clients on their journey of transformation. I always support and motivate my clients to overcome the challenges in their lives, to change their bad habits, and to achieve exceptional health. I am confident in my expertise to help clients change not only in their physique and willpower, but also in their training mindset. And more than that, I am confident that when clients journey with me, their sweat will be well worth it.</p>', '1995-01-12 00:00:00.000000', 'kendrall@gmail.com', '<p>2 years as a fitness trainer, 5 years of personal training</p>', '<p>Specializes in high-intensity interval training (HIIT) and functional fitness</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-shkrabaanthony-5878697.jpg?alt=media&token=3d9da057-9792-4a20-adbc-971a62166500', 'Junior coach', 'Kendrall James', '0397112674', 'Active', '2024-07-09 14:25:08.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('801f6d1d-d7c7-4767-b285-43bafc2d686c', '<ul><li>2021 Personal Trainer of the Year (Local Gym Chain)</li><li>Completed several Spartan Races and Tough Mudders</li></ul>', '<ul><li>Certified Personal Trainer (ACE)</li><li>Certified Functional Strength Coach (CFSC)</li></ul>', 'PT6266', '2024-06-29 15:30:33.000000', '<p>Personality: Energetic, motivational, patient, detail-oriented, results-driven</p><p>Coaching Philosophy: I believe in the power of small, consistent actions. Every rep, every step, every breath taken during training is a step towards your best self. Consistency beats intensity, and every bit of progress should be celebrated. Fitness is not a destination but a lifelong journey.</p><p>Coaching Approach: My role is to guide, motivate, and inspire my clients to push beyond their limits. I tailor my approach to fit each individual\'s needs and capabilities, focusing on building a solid foundation before pushing for advanced goals. I emphasize form and technique to ensure safety and efficiency, and I strive to make each session enjoyable and rewarding.</p>', '1992-01-22 00:00:00.000000', 'william.clark@example.com', '<p>3 years as a group fitness instructor, 4 years of personal training</p>', '<ul><li>Specializes in strength training and hypertrophy</li><li>Expertise in rehabilitation and corrective exercises</li><li>Skilled in designing training programs for beginners to advanced athletes</li></ul>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-shkrabaanthony-4401666.jpg?alt=media&token=132d557a-5caf-41d8-aa55-c850fb7bdaee', 'Junior coach', 'William Clark', '0345985151', 'Active', '2024-06-29 15:30:33.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('a1718422-0774-4079-b394-d24467bde6bf', '<ul><li>2020 Fitness Trainer of the Year (State Fitness Association)</li><li>Helped 50+ clients achieve their fitness goals in the past 2 years</li><li>Completed numerous endurance events including marathons and Ironman triathlons</li><li>Volunteer coach for local youth sports teams</li></ul>', '<ul><li>Certified Personal Trainer (NASM)</li><li>Certified Strength and Conditioning Specialist (CSCS)</li><li>Certified Sports Nutritionist (ISSN)</li><li>CPR and First Aid Certified</li></ul>', 'PT6723', '2024-06-29 15:20:18.000000', '<p>Personality: calm, disciplined, empathetic, perceptive, passionate about work</p><p>Coaching Philosophy: For me, only unwavering determination can truly transform people. There is no \"metamorphosis\" for those who are lazy about training. Think more, change more. Take care of yourself so that you can take care of your loved ones.&lt;/p&gt;&lt;p&gt;Coaching Approach: I see myself not just as a trainer, but as a companion, a \"spotter\" for my clients on their journey of transformation. I always support and motivate my clients to overcome the challenges in their lives, to change their bad habits, and to achieve exceptional health. I am confident in my expertise to help clients change not only in their physique and willpower, but also in their training mindset. And more than that, I am confident that when clients journey with me, their sweat will be well worth it.</p>', '1990-05-15 00:00:00.000000', 'benjamin.harris@example.com', '<p>2 years as a fitness trainer, 5 years of personal training</p>', '<ul><li>Specializes in high-intensity interval training (HIIT) and functional fitness</li><li>Expertise in sports nutrition and supplement guidance</li><li>Skilled in designing customized training programs for weight loss, muscle building, and athletic performance</li></ul>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-julia-larson-6456224.jpg?alt=media&token=90e8a448-0003-42d0-8fd1-c667a8ce8e9d', 'Senior coach', 'Benjamin Harris', '0379579176', 'Active', '2024-06-29 15:20:18.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `coach_schedules`
--

CREATE TABLE `coach_schedules` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL,
  `coach_id` varchar(255) DEFAULT NULL,
  `member_service_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `coach_schedules`
--

INSERT INTO `coach_schedules` (`id`, `created_at`, `description`, `end_date`, `start_date`, `title`, `type`, `updated_at`, `class_id`, `coach_id`, `member_service_id`) VALUES
('09b63eee-ed3e-4fdd-9848-9089fe85e7e9', '2024-06-29 17:48:10.000000', 'Busy with personal matters', '2024-06-30 08:30:00.000000', '2024-06-30 07:00:00.000000', 'Absent/Busy', 'busy', '2024-06-29 18:05:30.000000', NULL, '6769c773-9f37-48c0-aa63-d3aab5657b0c', NULL),
('0c0a6088-6a6e-46d0-b3ec-fe642fd373f7', '2024-07-04 23:15:39.000000', 'Training Session 2', '2024-07-07 09:30:00.000000', '2024-07-07 07:30:00.000000', 'Personal Training', 'PT', '2024-07-04 23:15:39.000000', NULL, '6769c773-9f37-48c0-aa63-d3aab5657b0c', 'f6f14f32-f3ae-4e92-a6c2-5d4714018d1e'),
('2a3e691d-1530-4fc1-868d-51bcbe7e52cb', '2024-07-11 11:51:31.000000', 'Class for beginners', '2024-07-11 16:30:00.000000', '2024-07-11 15:00:00.000000', 'Class for Beginners', 'class', '2024-07-11 11:51:31.000000', 'cd0b26c9-b2a5-43ea-a2b9-f20c6363b3d7', '72bc5b9d-949b-45c8-a210-690637382ee8', NULL),
('35817cf1-faff-46d1-b767-61f9fc76598a', '2024-07-03 03:33:35.000000', 'Training session 1', '2024-07-05 15:30:00.000000', '2024-07-05 14:00:00.000000', 'Personal Training', 'PT', '2024-07-04 00:31:50.000000', NULL, '6769c773-9f37-48c0-aa63-d3aab5657b0c', 'f6f14f32-f3ae-4e92-a6c2-5d4714018d1e'),
('3a65b5f6-c763-4891-9519-d9d71d7d01f7', '2024-07-03 23:36:10.000000', 'Advanced Strength Training class', '2024-07-06 10:15:00.000000', '2024-07-06 08:30:00.000000', 'Strength Training Advanced', 'class', '2024-07-03 23:36:10.000000', '9387216e-ba2c-450d-bf69-be3f3d06ddf8', '801f6d1d-d7c7-4767-b285-43bafc2d686c', NULL),
('3fa40862-18f9-400f-8bc0-edffa70c8539', '2024-07-10 09:32:15.000000', 'Busy ', '2024-07-10 16:00:00.000000', '2024-07-10 14:00:00.000000', 'Absent/Busy', 'busy', '2024-07-10 09:32:15.000000', NULL, '72bc5b9d-949b-45c8-a210-690637382ee8', NULL),
('9d5bb7be-6f73-4591-a54d-969642bbdf32', '2024-07-04 00:42:00.000000', 'Strength Training class conducted by Alex Tuner.', '2024-07-05 10:00:00.000000', '2024-07-05 08:45:00.000000', 'Strength Training Class', 'class', '2024-07-04 00:42:00.000000', '67d0b4dc-2e99-4d79-a670-d2f85fd4f247', '6769c773-9f37-48c0-aa63-d3aab5657b0c', NULL),
('9eda68e1-5353-4bbf-8a0c-398e7a1e2da9', '2024-07-03 23:44:31.000000', 'Class for old member', '2024-07-05 15:00:00.000000', '2024-07-05 14:00:00.000000', 'Old Mem Class', 'class', '2024-07-03 23:44:31.000000', '1a42b866-c79d-4773-8e96-1c6879492669', '801f6d1d-d7c7-4767-b285-43bafc2d686c', NULL),
('a2b98326-a84b-4486-ad87-c5db5d470114', '2024-07-03 23:39:02.000000', 'Training with ketchbell', '2024-07-06 15:00:00.000000', '2024-07-06 13:30:00.000000', 'Ketchbell Workout', 'class', '2024-07-03 23:39:02.000000', '46cb4057-9bd3-4542-8069-59355471bf5c', 'a1718422-0774-4079-b394-d24467bde6bf', NULL),
('c5aab47e-ca7b-419b-b237-a08721fceaae', '2024-07-03 03:08:10.000000', 'Training session 3', '2024-07-04 11:00:00.000000', '2024-07-04 09:00:00.000000', 'Personal Training', 'PT', '2024-07-03 03:08:10.000000', NULL, '6769c773-9f37-48c0-aa63-d3aab5657b0c', 'ce3ac839-19db-438e-8d63-6677e3de0bfb'),
('c63e8e98-2434-4a93-9d9f-458681a736ec', '2024-07-11 11:53:39.000000', 'Dumbbells', '2024-07-12 09:45:00.000000', '2024-07-12 08:00:00.000000', 'Training with dumbbells', 'class', '2024-07-11 11:53:39.000000', '8f805ad2-e711-41bb-826a-f222ced812ec', '6769c773-9f37-48c0-aa63-d3aab5657b0c', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `content_websites`
--

CREATE TABLE `content_websites` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `image` text DEFAULT NULL,
  `page` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `content_websites`
--

INSERT INTO `content_websites` (`id`, `created_at`, `description`, `image`, `page`, `title`, `type`, `updated_at`) VALUES
('1c96cac0-0e16-48c0-b3dd-7e37c5ffdc4e', '2024-06-28 00:19:34.000000', 'The photos below are the greatest assets we have. Eaglefit has helped hundreds of people like you, and of course, there are tips and tricks to prove it! Hidden behind each photo below are long stories about efforts to change yourself, to become a better, stronger, more disciplined version of yourself. These are just a few of the success stories of members at Eaglefit. They also had many difficulties losing weight on their own for a long time, but with Eaglefit\'s companion, results came to them in just a few months. Contact us now to become our next transform!', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-cottonbro-7674488.jpg?alt=media&token=ee445c0f-5de5-43b9-8407-7ac6d7888598', NULL, 'Transformation', 'intro-page', '2024-06-28 00:19:34.000000'),
('4cf03100-f8ae-4c74-8c0d-add268f27bd2', '2024-06-28 02:28:53.000000', '<p>Train at 5 clubs across the country and enjoy a best-in-class training environment, VIP area and special facilities such as Sauna, Swimming Pool and Jacuzzi.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_674964697_dP1wIkkinObgQMm4MJnHJMK5gTa6FxH5.jpg?alt=media&token=34528d48-26c9-463c-b9e3-56fae7bc42d0', 'Gyms Page', 'Standard of luxury', 'general-info', '2024-06-28 02:28:53.000000'),
('565272f1-10ec-487f-9f24-22c733a32577', '2024-06-28 02:33:17.000000', '<p>The coaching team at Eaglefit must undergo a well-structured 3-month training program and pass rigorous knowledge tests. Only the top performers are selected to become official coaches at Eaglefit.</p><p>Our training approach emphasizes professional knowledge, pedagogical skills, and the ability to investigate, analyze, and diagnose physical issues, so that each coach has the capability to design effective training programs for our customers.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-leonardho-1552249.jpg?alt=media&token=41393451-049c-4b10-a659-267ee931cac5', 'Coaches Page', 'Coach Training Methodology', 'general-info', '2024-06-28 02:33:17.000000'),
('6223fc1f-a2ec-4c22-b0b2-65ba0085f6d5', '2024-06-28 02:30:38.000000', '<p>The Eaglefit coaching team is not just service providers, they are your brothers, teammates, mentors, and personal trainers. They not only push you to overcome all your boundaries and limitations, but also provide emotional support when you feel tired and want to give up.</p><p>We operate our business on a foundation of knowledge, so each coach has a wealth of knowledge and experience. Not only do they have in-depth understanding of the fields of health, nutrition, and human anatomy and kinesiology, but they are also responsible and energetic companions who can motivate our members to reach new heights.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-julia-larson-6455781.jpg?alt=media&token=46b3471a-ce86-4334-9db3-d139bf59a780', 'Coaches Page', 'The Experienced and Knowledgeable Coaching Team', 'general-info', '2024-06-28 02:30:38.000000'),
('831f592b-978a-43bd-8c04-c09dcb5c294e', '2024-06-28 02:08:32.000000', '<p>As the best quality health brand, Eaglefit is built to bring happiness and create fulfilling moments for you in life by providing holistic physical, nutritional and mental health development services.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-olly-3768730.jpg?alt=media&token=d2b69707-2948-465b-bc5a-a8762c62e7a7', 'Home Page', 'We are eaglefit', 'general-info', '2024-06-28 02:08:32.000000'),
('88a33c9a-5318-4ebf-9355-fb2d61fbe0ba', '2024-06-28 02:37:06.000000', '<p>By becoming a member of Eaglefit, you will be able to participate in classes with an unlimited training program at 5 convenient locations nationwide, equipped with the latest Technogym equipment, as well as dry saunas, luxurious changing rooms, a swimming pool, a jacuzzi, a VIP lounge, and a fruit juice bar, and more.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-gustavo-fring-3984358.jpg?alt=media&token=7d30becb-0b37-40f0-8af6-decaf22ed3ba', 'Classes Page', 'Unlimited training program', 'general-info', '2024-06-28 02:37:06.000000'),
('898b8644-37f6-45b4-a068-904494c62a23', '2024-06-28 00:18:53.000000', 'Try something new by joining our exciting world of experiences. We offer a FREE TRIAL WORKOUT for all new customers. Leave your information and we will contact you within 24 hours at your preferred time.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-cottonbro-7674495.jpg?alt=media&token=6471f19e-92f1-4601-9bb0-6323bf8e4738', NULL, 'Free Trial Experience', 'intro-page', '2024-06-28 00:18:53.000000'),
('91588f77-8ee7-472a-82d9-796ebdee7abf', '2024-06-28 00:22:55.000000', 'Explore our diverse blog, covering a range of topics from News & Events to Workout Knowledge, Exercises, Nutrition, Health Guides, and inspiring Workout Stories. Find the information and inspiration you need to support your wellness journey.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-karolina-grabowska-4498606.jpg?alt=media&token=5fe8b65e-1673-4646-ab35-0c0cc7cf3cd8', NULL, 'Blog', 'intro-page', '2024-06-28 00:22:55.000000'),
('92270cbb-a07f-47a3-9eb4-0e6009c695db', '2024-06-28 00:20:05.000000', 'Eaglefit comprises 5 modern gyms with comfortable and convenient training spaces, providing all the necessary equipment and facilities to serve customers.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_727218629_ZEVLyGsl53GZqpOQRbP1vsG4eTwYxENF.jpg?alt=media&token=1366f83f-bffc-4577-881f-c7e4e6bafc36', NULL, 'Gym', 'intro-page', '2024-06-28 00:20:05.000000'),
('9364732f-c7df-4e28-bd21-574adb222f8b', '2024-06-28 14:19:42.000000', '<p>Enjoy endless joy with over 50 copyright group classes from Lesmills such as Body Combat, Body Jam, RPM, SH\'Bam and exclusive programs designed by Eaglefit. New versions are constantly updated every month.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-olly-3768730.jpg?alt=media&token=3f651365-681e-4135-be87-117913c79378', 'Service Page', 'Unlimited group classes', 'general-info', '2024-06-28 14:19:42.000000'),
('a41aef4c-4d89-414a-91a4-1ace314aa1d9', '2024-06-28 00:21:56.000000', 'Eagleft\'s classes offer a diverse range of programs to cater to the unique needs and goals of our members. From high-intensity interval training to relaxing yoga sessions, we have something for everyone. Immerse yourself in a supportive and motivating environment, where our experienced instructors guide you through each workout, ensuring you get the most out of your workout journey.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-tima-miroshnichenko-6582869.jpg?alt=media&token=440f1fc0-4f91-4edb-9da2-5324053765ff', NULL, 'Class', 'intro-page', '2024-06-28 00:21:56.000000'),
('ae4ffd65-e37c-4d1f-9f34-bcb6d3c654d1', '2024-06-28 02:26:42.000000', '<ul><li>Convenient club locations nationwide</li><li>Unlimited training programs</li><li>International standard trainers</li><li>Diverse membership packages to suit your needs</li><li>Health benefits through the Livwell app\'s reward points exchange</li><li>Personal accident insurance up to 1 billion VND for new members</li><li>Diverse partner discounts</li></ul>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-pixabay-416809.jpg?alt=media&token=0ed31003-6439-494f-8121-f300e6a23f12', 'Free Trial Page', 'Benefits of Eaglefit membership', 'general-info', '2024-06-28 02:26:42.000000'),
('bd230d0a-1201-4121-bec3-be3b71916d57', '2024-06-28 14:29:17.000000', '<p>Achieve your fitness goals with personalized training from our certified trainers. Tailored plans and one-on-one sessions ensure you get the best results. Start your journey to a healthier, stronger you today.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-thisisengineering-3912953.jpg?alt=media&token=65ae70cb-9d41-4507-84f0-89fe87058fab', 'Service Page', 'Personal Training Excellence', 'general-info', '2024-06-28 14:29:17.000000'),
('c6782ce0-6958-4cc2-95cf-548c926fca5d', '2024-06-28 02:22:03.000000', '<p>Over the years, more than 100,000 people have chosen us to start their training journey. Let\'s discover why Eaglefit is trusted by many members!</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-olly-3768916.jpg?alt=media&token=40f5c910-9f0f-42c1-99c6-882ea53f1250', 'Home Page', 'Make dreams come true', 'general-info', '2024-06-28 02:22:03.000000'),
('c7d688a0-7883-46e6-8aa0-4417d5cb4e35', '2024-06-28 00:22:26.000000', 'Explore our extensive Exercise Library filled with a diverse collection of workout videos and fitness routines to help you reach your fitness goals. Whether you\'re a beginner or an experienced gym-goer, our library has something for everyone to challenge and inspire your workouts.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-823sl-371049.jpg?alt=media&token=87b2cf0e-c1d2-40c4-a1a0-d4ab3aa0648a', NULL, 'Exercise Library', 'intro-page', '2024-06-28 00:22:26.000000'),
('cea7a0bb-f6f8-4ca8-83ae-cbfda64970c7', '2024-06-28 14:21:35.000000', '<p>Practice authentic Yoga under the guidance of Indian Yoga Masters. Achieve perfect balance by building strength, flexibility, and body suppleness while completely relaxing all senses and freeing the mind.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-cottonbro-4056535.jpg?alt=media&token=ecf5e36e-8249-4d88-a4f8-5670eb323598', 'Service Page', 'The essence of Indian Yoga', 'general-info', '2024-06-28 14:21:35.000000'),
('d0d4b3f0-8ade-4132-bfda-afcedba79ebf', '2024-06-28 02:19:22.000000', '<p>Train at over 20+ clubs across the country and enjoy a best-in-class training environment, VIP area and special facilities such as Sauna, Swimming Pool and Jacuzzi.</p>', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-heyho-7031705.jpg?alt=media&token=5bc02cb2-be34-4bea-b579-f46d3d9298b7', 'Home Page', 'Standard of luxury', 'general-info', '2024-06-28 02:19:22.000000'),
('d6f33336-0a5a-40a7-b42f-05a1f2c722de', '2024-06-28 00:20:53.000000', 'The coaching team of Eaglefit is carefully screened, and they must undergo at least 3 months of training to have the necessary communication skills and professional knowledge to guide the customers.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-julia-larson-6455818.jpg?alt=media&token=991c8b4b-9b35-4885-b235-ccffdeb341b6', NULL, 'Coach', 'intro-page', '2024-06-28 00:20:53.000000'),
('fbe43e2b-fea5-453c-a5c8-29c503ffdb00', '2024-06-28 00:21:25.000000', 'As the largest health brand in Vietnam, Eaglefit was built to bring happiness and create fulfilling moments for you in life by providing comprehensive physical, nutritional, and mental health development services.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-felix-young-449360607-20060599.jpg?alt=media&token=155c7514-31c9-4e8c-ac8f-1274c798113d', NULL, 'Service', 'intro-page', '2024-06-28 00:21:25.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `equipments`
--

CREATE TABLE `equipments` (
  `id` varchar(255) NOT NULL,
  `available_quantity` int(11) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `image_url` text DEFAULT NULL,
  `list_code` text DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `purchase_date` datetime(6) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `under_maintenance_quantity` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `warranty_expiration` datetime(6) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `equipments`
--

INSERT INTO `equipments` (`id`, `available_quantity`, `created_at`, `image_url`, `list_code`, `manufacturer`, `name`, `purchase_date`, `total_price`, `total_quantity`, `under_maintenance_quantity`, `unit_price`, `updated_at`, `warranty_expiration`, `category_id`, `gym_id`) VALUES
('4943e101-d2c5-4977-b4f7-45d78e6da5a3', 8, NULL, 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fimpulse-rl8101-may-tap-nguc-xo-chest-press-row.jpg?alt=media&token=9be69df5-333d-47aa-9c8c-b8030bd22fc4', 'ZGHN9421-IYIJ9172-TLRX1381-UJWD7686-HSMT0140-SGPV5737-ZITO2524-RGVS1767', 'Nautilus', 'Incline Weight Bench', '2024-06-29 00:00:00.000000', 3520, 8, 0, 440, NULL, '2025-12-28 00:00:00.000000', '08286d2d-b07e-415b-abcf-e7134cbd5b44', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('5b2a723e-5b4a-4e88-bc75-2de689df794e', 4, NULL, 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Flong-tap-da-nang-hoist-mc7005-p1.jpg?alt=media&token=cb94dee3-d16e-4c01-a287-2f5a1f314f17', 'IVZS9343-SXSS8078-ERNJ0123-SGTD4512', 'Matrix Fitness', 'Commercial Elliptical Trainer', '2024-06-29 00:00:00.000000', 11200, 4, 0, 2800, NULL, '2027-06-28 00:00:00.000000', 'd91c30e8-0eff-49d6-b903-121246b0dea6', '0fd1e17c-28eb-4b47-9b80-821e8321a1e5'),
('75055b4d-8578-460f-bde2-4afbcfea56b2', 5, NULL, 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fxe-dap-co-tua-lung-impulse-encore-ecr7b-768x768.jpg?alt=media&token=5faf2ed1-4c68-4731-86a6-8599bda1b2fe', 'RENG6570-TDDS9291-KAEW7368-ZHZW1040-NAPE0161', 'Life Fitness', 'Double Bar Belly Kick Frame', '2024-06-29 00:00:00.000000', 4875, 5, 0, 975, NULL, '2025-06-28 00:00:00.000000', 'd4ad419e-825e-4f1c-a422-74a06e59a449', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('91b01120-6e53-473f-9721-2dff56358eee', 10, NULL, 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fghe-tap-bung-va-squat-pt5043-vifa-601009.jpg?alt=media&token=ad6fee16-8f6b-4178-ba97-6b968202564b', 'WODN2487-BJLJ8513-UJIZ0907-ERFH7951-WNGY4346-VEMU9351-WOSD4094-QYZF3143-OKQR4350-PPOS5904', 'Technogym', 'Adjustable Kettlebell Set', '2024-06-13 00:00:00.000000', 12000, 10, 0, 1200, NULL, '2026-06-12 00:00:00.000000', 'eb2231e1-10c0-444a-9ba8-038022c5c78f', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('9b2497b3-aefc-486b-848d-3a1356cacc27', 5, NULL, 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fmay-tap-toan-than-cao-cap-life-fitness-cross-trainer-integrity-sl-console.jpg?alt=media&token=4a91fcde-a6dd-4582-93bb-0e18ff265e67', 'BQWE0191-LJIO1812-YBQK5714-JTNX9537-IOKK2312', 'Precor', 'Double Bar Belly Kick Frame', '2024-06-18 00:00:00.000000', 4875, 5, 0, 975, NULL, '2026-06-17 00:00:00.000000', 'd4ad419e-825e-4f1c-a422-74a06e59a449', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('ed2e885b-b422-47c8-a81e-1e1233684101', 2, NULL, 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fimpulse-FE9720-may-du-xa-tro-luc-weight-addidted-chin-dip-combo-p01-768x768.jpg?alt=media&token=d2aef630-c335-43c8-8263-91746e258e5d', 'FCQN5318-SUYZ0592', 'Precor', 'Hex Dumbbells Set', '2024-06-27 00:00:00.000000', 7000, 2, 0, 3500, NULL, '2027-06-26 00:00:00.000000', '9f9a6eb1-1a79-497a-85bb-a0fd99170fe3', '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `equipment_categories`
--

CREATE TABLE `equipment_categories` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `equipment_categories`
--

INSERT INTO `equipment_categories` (`id`, `created_at`, `name`, `quantity`, `updated_at`) VALUES
('08286d2d-b07e-415b-abcf-e7134cbd5b44', '2024-06-29 03:45:17.000000', 'Weight Bench', 8, '2024-06-29 03:45:17.000000'),
('1ccda90d-1113-4c1d-9dff-7bd0e02c3506', '2024-06-29 03:44:56.000000', 'Stationary Bike', 0, '2024-06-29 03:44:56.000000'),
('1fecd4aa-d9b3-473d-b8f8-198a06f6e4a6', '2024-06-29 03:44:25.000000', 'Treadmill', 0, '2024-06-29 03:44:25.000000'),
('9f9a6eb1-1a79-497a-85bb-a0fd99170fe3', '2024-06-29 03:45:23.000000', 'Dumbbells', 2, '2024-06-29 03:56:55.000000'),
('d4ad419e-825e-4f1c-a422-74a06e59a449', '2024-06-29 03:45:10.000000', 'Rowing Machine', 10, '2024-06-29 04:25:16.000000'),
('d91c30e8-0eff-49d6-b903-121246b0dea6', '2024-06-29 03:45:04.000000', 'Elliptical Machine', 4, '2024-06-29 03:45:04.000000'),
('eb2231e1-10c0-444a-9ba8-038022c5c78f', '2024-06-29 03:45:30.000000', 'Kettlebell', 10, '2024-06-29 03:50:13.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `equipment_repairs`
--

CREATE TABLE `equipment_repairs` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `issue_description` varchar(255) DEFAULT NULL,
  `repair_cost` double DEFAULT NULL,
  `repair_date` datetime(6) DEFAULT NULL,
  `repair_description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `equipment_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `equipment_repairs`
--

INSERT INTO `equipment_repairs` (`id`, `code`, `created_at`, `issue_description`, `repair_cost`, `repair_date`, `repair_description`, `status`, `updated_at`, `equipment_id`) VALUES
('0b923848-31c4-4c0a-884c-4191427caaca', 'IYIJ9172', '2024-06-29 13:16:35.000000', 'Belt slipping', 250, '2024-06-13 00:00:00.000000', 'Adjusted belt tension and replaced worn belt', 'Completed', '2024-06-29 13:16:35.000000', '4943e101-d2c5-4977-b4f7-45d78e6da5a3'),
('5926b1ee-fe1a-40bf-89ff-708fd79f6c73', 'WODN2487', '2024-06-29 13:17:55.000000', 'Display not working', 200, '2024-06-24 00:00:00.000000', 'Replaced display unit and checked wiring', 'Completed', '2024-06-29 13:17:55.000000', '91b01120-6e53-473f-9721-2dff56358eee'),
('683a7283-dc88-4ae3-a700-cce16e139fec', 'SGPV5737', '2024-07-11 16:33:54.000000', 'Broke screen', 150, '2024-07-08 00:00:00.000000', 'Repair screen', 'Completed', '2024-07-11 16:33:54.000000', '4943e101-d2c5-4977-b4f7-45d78e6da5a3'),
('71657649-0069-4ea3-9b5d-7ae2417e9ba6', 'HSMT0140', '2024-06-29 13:18:35.000000', 'Weight bench padding torn', 75, '2024-06-28 00:00:00.000000', 'Replaced padding and cover', 'Completed', '2024-06-29 13:18:35.000000', '4943e101-d2c5-4977-b4f7-45d78e6da5a3'),
('af2a4586-7d23-495f-b6a7-9fb7d737299c', 'JTNX9537', '2024-06-29 13:19:24.000000', 'Resistance not working', 180, '2024-06-28 00:00:00.000000', 'Fixed resistance mechanism and replaced broken parts', 'Completed', '2024-06-29 13:19:24.000000', '9b2497b3-aefc-486b-848d-3a1356cacc27'),
('d1dc2632-1049-4457-b6d3-7b48a7a6d2d3', 'SUYZ0592', '2024-06-29 13:20:05.000000', 'Dumbbell rack unstable', 80, '2024-06-29 00:00:00.000000', 'Reinforced rack structure and tightened all bolts', 'Completed', '2024-08-12 15:54:47.000000', 'ed2e885b-b422-47c8-a81e-1e1233684101'),
('e7d95686-efdc-44d0-a36c-17d6258521da', 'RENG6570', '2024-06-29 13:17:10.000000', 'Machine making noise', 120, '2024-06-17 00:00:00.000000', 'Replaced faulty bearings and lubricated joints', 'Completed', '2024-06-29 13:17:10.000000', '75055b4d-8578-460f-bde2-4afbcfea56b2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `exercise_categories`
--

CREATE TABLE `exercise_categories` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `exercise_categories`
--

INSERT INTO `exercise_categories` (`id`, `created_at`, `name`, `updated_at`) VALUES
('05ca9a5f-937e-4b1c-b9b8-70aeebb351fc', '2024-06-27 00:33:05.000000', 'Core', '2024-07-01 04:25:40.000000'),
('2d6725c1-9dea-4659-a84b-5b932f05c7fa', '2024-06-27 00:32:51.000000', 'Pilates', '2024-06-27 00:32:51.000000'),
('4eb9a4ab-86ad-452c-8b7a-54a264f9fca0', '2024-06-27 00:32:40.000000', 'Cardio', '2024-06-27 12:14:25.000000'),
('5c691734-7587-4a9c-b5b0-3b764c0ec35b', '2024-06-27 00:32:59.000000', 'Full Body', '2024-07-11 11:57:21.000000'),
('75f7faf7-922b-4f60-a24a-c807b096afa3', '2024-06-27 00:33:21.000000', 'Upper Body', '2024-06-27 00:33:21.000000'),
('829464e9-e817-4edb-8645-8dc36e4b4fc5', '2024-06-27 00:33:13.000000', 'Lower Body', '2024-06-27 00:33:13.000000'),
('94487cd7-45fc-4be8-bf65-0774952ddd01', '2024-06-27 00:32:44.000000', 'Yoga', '2024-06-27 00:32:44.000000'),
('b6d88fec-e3db-466c-9295-02754cc1cb1f', '2024-06-27 00:32:33.000000', 'Strength Training', '2024-06-27 12:11:58.000000'),
('bf844f95-2a37-4fb8-8ef3-826d0d80bf12', '2024-06-27 00:30:30.000000', 'Mobility', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `exercise_libraries`
--

CREATE TABLE `exercise_libraries` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `thumbnail` text DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `youtube_url` text DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `exercise_libraries`
--

INSERT INTO `exercise_libraries` (`id`, `created_at`, `description`, `level`, `thumbnail`, `title`, `updated_at`, `youtube_url`, `category_id`) VALUES
('15991c4d-b50f-4425-a1ac-357678a83088', '2024-06-27 14:33:04.000000', 'Get a full upper body workout in just 20 minutes with no equipment needed!', 'Advanced', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-panther-1547248.jpg?alt=media&token=ced905c4-0109-4590-95cc-c5fbb9880eac', '20 MINUTE UPPER BODY WORKOUT(NO EQUIPMENT)', '2024-06-27 14:33:04.000000', 'https://www.youtube.com/embed/mm47bCaCzpQ', '75f7faf7-922b-4f60-a24a-c807b096afa3'),
('352afd93-65a6-419f-9459-3069a422b4dd', '2024-06-27 14:43:27.000000', 'Get started going to the gym the RIGHT way!', 'Beginner', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-victorfreitas-703016.jpg?alt=media&token=32f1b261-5da5-471a-b7d1-0fb98202d2ca', 'Beginner\'s Guide to the Gym | DO\'s and DON\'Ts', '2024-06-27 16:56:50.000000', 'https://www.youtube.com/embed/EKUNGQ4LmH8', '05ca9a5f-937e-4b1c-b9b8-70aeebb351fc'),
('367ae5e7-2777-4f76-b393-00871721d3c7', '2024-06-27 14:22:17.000000', 'Work the entire body with this 30 Minute Moderate Full Body Pilates Workout!', 'Beginner', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-alexy-almond-3756521.jpg?alt=media&token=c6d24a6b-570b-4049-8cac-f399eb9f206c', '30 MIN FULL BODY WORKOUT || At-Home Pilates (No Equipment)', '2024-06-27 14:22:17.000000', 'https://www.youtube.com/embed/C2HX2pNbUCM', '2d6725c1-9dea-4659-a84b-5b932f05c7fa'),
('589d7c0c-3b5a-444d-a072-4d50f8e7361e', '2024-06-27 14:05:40.000000', 'A classic upper body exercise that isolates and strengthens the biceps.', 'Advanced', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-thisisengineering-3912953.jpg?alt=media&token=8ce2f3b2-8694-4d8b-8989-e0884b9f46da', '30 Min FULL BODY DUMBBELL WORKOUT at Home + HIIT Finisher', '2024-06-27 14:05:40.000000', 'https://www.youtube.com/embed/Jpxc0TUr9BI', '5c691734-7587-4a9c-b5b0-3b764c0ec35b'),
('596e9079-77d0-4cfb-a389-b6e3bbd423ff', '2024-06-27 14:26:59.000000', 'It\'s a 3 weeks weight loss challenge! Join us all in this FUN new challenge. ', 'Intermediate', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-olly-3768916.jpg?alt=media&token=3d149c44-dd07-48f9-ba91-35d545e81083', '10 Min Cardio workout to burn Fat | Fun 3 Week Weight Loss Challenge', '2024-06-27 14:26:59.000000', 'https://www.youtube.com/embed/fUJjsUn9bCo', '4eb9a4ab-86ad-452c-8b7a-54a264f9fca0'),
('83321245-fef7-4022-857f-2bd3c296392b', '2024-06-27 14:38:08.000000', 'Time to work on those legs and butt of yours in the third episode of my 2 weeks challenge.', 'Intermediate', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-cottonbro-5310883.jpg?alt=media&token=52b1b05a-e488-4935-886d-6d88b1b35562', 'Lower Body Workout | Toned Legs & Butt | 2 Weeks Challenge', '2024-06-27 14:38:08.000000', 'https://www.youtube.com/embed/I9nG-G4B5Bs', '829464e9-e817-4edb-8645-8dc36e4b4fc5'),
('9ec36380-3851-41d1-b8e3-ffe453c64c00', '2024-06-27 14:07:08.000000', 'A core-strengthening exercise that engages the entire body in a static hold.', 'Beginner', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-felix-young-449360607-20060599.jpg?alt=media&token=21c79526-550e-4758-888a-45d2bd9ee604', '15 MIN HOURGLASS WORKOUT - 3in1 Legs, Abs & Back - Beginner to Medium Level', '2024-06-27 14:17:54.000000', 'https://www.youtube.com/embed/rjKUSPxZ6pw', 'bf844f95-2a37-4fb8-8ef3-826d0d80bf12'),
('b5a5945e-6b44-49e2-b621-afa67a029bc3', '2024-06-27 11:59:38.000000', 'Perfect for busy schedules, get fit efficiently with minimal equipment!', 'Intermediate', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-olly-3838389.jpg?alt=media&token=fa8f8ed0-4619-4fc7-b86b-1e8942ddedd5', 'The Best Science-Based Minimalist Workout Plan (Under 45 Mins)', '2024-06-27 12:37:00.000000', 'https://www.youtube.com/embed/eMjyvIQbn9M', 'b6d88fec-e3db-466c-9295-02754cc1cb1f'),
('b70e9a6c-bc54-4720-92e3-787183fd602e', '2024-06-27 13:58:43.000000', 'In this video you are going to learn 4 core exercises for beginners that will help you build core strength.', 'Beginner', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-gustavo-fring-4920478.jpg?alt=media&token=cfee0e72-953b-475e-a92f-a2f4a1447ec7', '4 Best core exercises for beginners', '2024-06-27 13:58:43.000000', 'https://www.youtube.com/embed/3XVGDYuPay4', '05ca9a5f-937e-4b1c-b9b8-70aeebb351fc'),
('c8494ffb-0da2-4190-99ab-eec12a0d8dba', '2024-06-27 14:40:37.000000', 'Just watch how your body calms down & lets go of physical and mental tension.', 'Beginner', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-cliff-booth-4056724.jpg?alt=media&token=8d688896-a508-417b-b4bc-e88338d678b9', '10 MIN SLOW YOGA + BREATHING - Anti Stress / for mornings, before bed or after a workout', '2024-06-27 16:56:58.000000', 'https://www.youtube.com/embed/0tjssNmUEH4', '94487cd7-45fc-4be8-bf65-0774952ddd01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gyms`
--

CREATE TABLE `gyms` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `amenity` text DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `list_image` longtext DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `operating_time` text DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `thumbnail` text DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `gyms`
--

INSERT INTO `gyms` (`id`, `address`, `amenity`, `created_at`, `description`, `list_image`, `name`, `operating_time`, `phone`, `status`, `thumbnail`, `updated_at`) VALUES
('0fd1e17c-28eb-4b47-9b80-821e8321a1e5', '21 Oak St, Burbank, CA 91504', '[\"Boxing Ring\",\"TRX Area\",\"Rowing Machines\",\"Rock Climbing Wall\",\"Foam Rollers\"]', '2024-06-28 11:11:08.000000', 'The Cali Tower gym in Burbank, California offers a world-class fitness experience. With state-of-the-art equipment, a team of highly trained and certified instructors, and a wide range of group classes and personalized training programs, this location caters to the needs of fitness enthusiasts of all levels, helping them achieve their health and wellness goals in a modern and inspiring environment.', '[\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Febe1435a08e46b64efaff33d69ed05b7.jpg?alt=media&token=b951a4ac-7dfe-4ea3-9076-a09e49f84660\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F472cbc96d899542f68ddf825fe02b6b8.jpg?alt=media&token=7e2b30fa-8be6-4765-af26-9ab5bde970b0\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F0abbca7e2aa026a50804b94a606b2764.jpg?alt=media&token=485d8906-88d8-485d-b338-7d08b63fe58c\"]', 'Cali Tower - Burbank, California', '{\"Monday\":\"06:00 - 22:00\",\"Tuesday\":\"06:00 - 22:00\",\"Wednesday\":\"06:00 - 22:00\",\"Thursday\":\"06:00 - 22:00\",\"Friday\":\"06:00 - 22:00\",\"Saturday\":\"06:00 - 20:00\",\"Sunday\":\"06:00 - 19:00\"}', '0387984195', 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_634364277_5uF310nAaUo3mywY9bSfG8v7Q4qsh2Vz.jpg?alt=media&token=be410ed8-172c-4b47-8f86-3314b823e43d', '2024-08-12 15:51:25.000000'),
('53681847-cff7-495b-82ab-47eff6008878', '123 Main St, Springfield, IL 62701', '[\"Cardio Machines\",\"Free Weights\",\"Group Classes\",\"Personal Training\",\"Sauna & Steam\"]', '2024-06-28 10:58:44.000000', 'The Goldview gym in Springfield, Illinois offers a comprehensive and state-of-the-art fitness experience. With a wide range of modern equipment, expert trainers, and spacious workout areas, this location caters to fitness enthusiasts of all levels, helping them achieve their health and wellness goals.', '[\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F592b7ee88a257659a5375552b72ab7ab.jpg?alt=media&token=ef5ee017-1df3-41fc-ba6a-0ff349cc5ef9\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fa28fdad4aa4edd527cc0d4097c45870c.jpg?alt=media&token=cc2d4bd8-c11c-43cf-8268-b06837629f6b\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fb9a3dab11a1def1b3b35d5a2a02d86ae.jpg?alt=media&token=0fd39b2b-c2ad-4cb9-916d-1c5fd94173fd\"]', 'Goldview - Springfield, Illinois', '{\"Monday\":\"06:00 - 22:00\",\"Tuesday\":\"06:00 - 22:00\",\"Wednesday\":\"06:00 - 22:00\",\"Thursday\":\"06:00 - 22:00\",\"Friday\":\"06:00 - 22:00\",\"Saturday\":\"08:00 - 20:00\",\"Sunday\":\"08:00 - 20:00\"}', '0631876156', 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_734691551_c4uzOIq1Gtk7KO9sZbWEI83mZwsJvLyf.jpg?alt=media&token=85f64bd6-1a60-4e08-8015-11c38aa7d3c9', '2024-07-03 03:05:59.000000'),
('60d6225b-e81e-4b08-937e-279612300898', '456 Oak Rd, Greenville, SC 29601', '[\"Yoga Studio\",\"Locker Rooms\",\"Swimming Pool\",\"Spa Services\",\"Juice Bar\",\"Boxing Ring\"]', '2024-06-28 11:04:30.000000', 'Vivo City gym in Greenville, South Carolina offers a comprehensive and cutting-edge fitness experience. With state-of-the-art equipment, a team of dedicated trainers, and a variety of group classes, this location caters to individuals of all fitness levels, helping them achieve their health and wellness goals in a modern and welcoming environment.', '[\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F70dbae65ccce8aa5e80f86b9c249fe4f.jpg?alt=media&token=84448a96-e73a-4142-9d28-1bb9a996b67b\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F4e10a86111f391d7e0e338d7ce6b2dd2.jpg?alt=media&token=573b647e-59ff-4233-a61f-404c4fd57833\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Ff7a6f499e7e7a9f84a4963bec6ba6536.jpg?alt=media&token=121a2084-b015-4443-8f5c-e0ff4299100a\"]', 'Vivo City - Greenville, South Carolina', '{\"Monday\":\"06:30 - 21:30\",\"Tuesday\":\"06:30 - 21:30\",\"Wednesday\":\"06:30 - 21:30\",\"Thursday\":\"06:30 - 21:30\",\"Friday\":\"06:30 - 21:30\",\"Saturday\":\"07:00 - 19:00\",\"Sunday\":\"08:00 - 18:00\"}', '0358946184', 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_731319702_UEHGuffaNwEBMDZsdkBBIdSOiy3PSBlZ.jpg?alt=media&token=bcaaa6ce-c69f-4f17-88a8-9df4bfd2ef72', '2024-06-28 11:55:43.000000'),
('7f930c50-d031-418f-8036-bc8bf7851ba6', '159 Pine Rd, Jefferson City, MO 65101', '[\"Sauna\",\"Steam Room\",\"Towel Service\",\"Childcare\",\"Group Classes\"]', '2024-06-28 11:14:40.000000', 'Parkson Flemington gym in Jefferson City, Missouri offers a diverse and high-quality fitness experience. With a wide range of modern equipment, specialized training programs, and a team of experienced instructors, this location caters to the needs of fitness enthusiasts of all levels, helping them achieve their health and wellness goals in a comfortable and welcoming environment.', '[\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F101758629526e606d7cb67cfb727acb0.jpg?alt=media&token=b3cd54c1-0c1b-4659-9c69-1844b15a511f\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F43423010af8eed9849d1900d4a593fd8.jpg?alt=media&token=5f409015-631a-478b-bde5-9d4ec58ac2cf\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F18cc9d03853017009fb033ecd4356fd0.jpg?alt=media&token=69c52fae-8534-4818-bfa3-5b79b2c385c3\"]', 'Flemington - Jefferson City, Missouri', '{\"Monday\":\"06:00 - 22:00\",\"Tuesday\":\"06:00 - 22:00\",\"Wednesday\":\"06:00 - 22:00\",\"Thursday\":\"06:00 - 22:00\",\"Friday\":\"06:00 - 22:00\",\"Saturday\":\"07:00 - 19:00\",\"Sunday\":\"08:00 - 18:00\"}', '0359846135', 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_674964697_dP1wIkkinObgQMm4MJnHJMK5gTa6FxH5.jpg?alt=media&token=f022b293-5512-4b29-8ec7-c62fa06ea151', '2024-06-28 11:14:40.000000'),
('9843d92e-e539-4353-b5ea-1a52eea08444', '789 Maple Blvd, Fairfax, VA 22030', '[\"Pilates Studio\",\"Cycling Studio\",\"Sauna\",\"Steam Room\",\"Massage Chairs\"]', '2024-06-28 11:08:04.000000', 'Pico Plaza gym in Fairfax, Virginia offers a diverse and high-quality fitness experience. With a wide range of equipment, specialized training programs, and a team of experienced instructors, this location caters to the needs of fitness enthusiasts of all levels, helping them achieve their health and wellness goals in a comfortable and welcoming environment.', '[\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F83f2b3de4cdf89b381663d755f6e4f35.jpg?alt=media&token=58635f7f-4074-41fa-b062-5114f84b96bc\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F053b2f5fef5d8887be0835d5e8ed2423.jpg?alt=media&token=da2db619-1d8d-494a-831e-3daf33d436ed\",\"https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F8d06b25766ad0bfeb729bf2225d45bf9.jpg?alt=media&token=f7f87e25-4cf8-47a4-ad42-c1e865c9fbc4\"]', 'Pico Plaza - Fairfax, Virginia', '{\"Monday\":\"06:00 - 22:00\",\"Tuesday\":\"06:00 - 22:00\",\"Wednesday\":\"06:00 - 22:00\",\"Thursday\":\"06:00 - 22:00\",\"Friday\":\"06:00 - 22:00\",\"Saturday\":\"06:00 - 21:00\",\"Sunday\":\"07:00 - 19:00\"}', '0359786180', 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F1000_F_621627290_pEPZm3MP6Evnn8OVnFrtWhnIV6GRLgrn.jpg?alt=media&token=02d950ab-262f-40c5-9f27-8040b8b7ef93', '2024-06-28 11:08:04.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `members`
--

CREATE TABLE `members` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `members`
--

INSERT INTO `members` (`id`, `code`, `created_at`, `dob`, `email`, `gender`, `name`, `phone`, `updated_at`, `gym_id`) VALUES
('24efb7ae-a437-43b6-b2e2-c9ceb8316dd3', 'N7035482', '2024-07-11 16:54:07.000000', '2002-01-17 00:00:00.000000', 'a.nguyenvan@gmail.com', 'Male', 'Nguyen Van A', '0319756757', '2024-07-11 16:54:07.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('33cfc744-91e0-47eb-b526-5f6dbe9e5a92', 'M4238623', '2024-07-11 11:42:08.000000', '1999-01-22 00:00:00.000000', 'mike.simons@gmail.com', 'Male', 'Mike Simons', '0379572126', '2024-07-11 11:42:08.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('368505d2-4490-4bb7-adda-7fe18b5fe0b3', 'S3056879', '2024-07-09 14:18:57.000000', '1996-01-24 00:00:00.000000', 'raul.sergio@gmail.com', 'Male', 'Sergio Raul', '0312795981', '2024-07-09 14:18:57.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('5172f6c6-3d94-4998-99c6-ac923d10b180', 'J1617129', '2024-07-09 14:18:47.000000', '1997-01-23 00:00:00.000000', 'josh.moore@gmail.com', 'Male', 'Joshua Moore', '0348756125', '2024-07-09 14:18:47.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('52712bf2-c872-4ab3-a8ff-8520d66aca00', 'T6049436', '2024-07-11 11:44:37.000000', '1997-07-28 00:00:00.000000', 'b.tranvan@gmail.com', 'Male', 'Tran Van B', '0397156758', '2024-07-11 11:44:37.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('9cd8ab7a-c56c-4011-95cf-840992e2fdec', 'C2896562', '2024-07-07 16:03:47.000000', '1999-01-20 00:00:00.000000', 'cody.gary@gmail.com', 'Male', 'Cody Gary', '0397675215', '2024-07-07 16:03:47.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('a0071df0-34f5-4c47-8cda-6b955f03f78f', 'A2195798', '2024-07-09 03:06:48.000000', '2000-01-16 00:00:00.000000', 'andrew.mill@gmail.com', 'Male', 'Andrew Miller', '0321769751', '2024-07-09 03:06:48.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('a05f0a89-3059-484f-aefc-122d97951aed', 'J0425062', '2024-06-29 23:23:16.000000', '1998-03-20 00:00:00.000000', 'jack12henry@gmail.com', 'Male', 'Jack Henry', '0359849556', '2024-06-29 23:23:16.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('a119d809-d24e-4643-bfb1-71e87ea03367', 'E0529019', '2024-07-03 03:30:30.000000', '2002-01-25 00:00:00.000000', 'emily.davis@gmail.com', 'Female', 'Emily Davis', '0329850375', '2024-07-03 03:30:30.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('b0b797b4-9dfd-4471-848f-98d9851b14fb', 'H1502373', '2024-07-09 03:12:05.000000', '1996-01-12 00:00:00.000000', 'haper12@gmail.com', 'Female', 'Harper Walker', '0329845181', '2024-07-09 03:12:05.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('bdeb6f6b-2e71-4752-93a6-21c7aaa80903', 'J1635414', '2024-06-30 03:31:17.000000', '1996-01-24 00:00:00.000000', 'jnagelsmann@gmail.com', 'Male', 'Julian Nagelsmann', '0397815651', '2024-06-30 03:31:17.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('bfac707e-1086-4e93-94f0-3a6e2eb19517', 'A6987698', '2024-07-09 02:59:53.000000', '1995-01-13 00:00:00.000000', 'amelia@gmail.com', 'Female', 'Amelia Lewis', '0381269997', '2024-07-09 02:59:53.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('c614dfc2-28d1-463b-8db8-503d5411a4cb', 'D7473785', '2024-07-09 02:53:58.000000', '2003-01-17 00:00:00.000000', 'ducnguyen@gmail.com', 'Male', 'Duc Nguyen', '0379121124', '2024-07-09 02:53:58.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('d39ee1ad-a960-4092-86fb-9a12dc902167', 'H5339128', '2024-07-09 02:41:14.000000', '1998-03-26 00:00:00.000000', 'hana.svi@gmail.com', 'Female', 'Hana Svitolina', '0378126205', '2024-07-09 02:41:14.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('db2661c0-c9aa-4afc-b246-cd4f8d0bb9cd', 'B2686783', '2024-07-09 02:36:09.000000', '2000-01-30 00:00:00.000000', 'bas.kingston@gmail.com', 'Male', 'Bastian Kingston', '0329546755', '2024-07-09 02:36:09.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('db33e0bf-fca2-4424-9d56-173452da6248', 'P8327457', '2024-07-11 14:26:52.000000', '2001-01-19 00:00:00.000000', 'v.pham56@gmail.com', 'Male', 'Pham Van V', '0395715712', '2024-07-11 14:26:52.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('ddaf4153-90d9-4939-b9f0-b70d37c33ca2', 'R2307668', '2024-06-30 03:49:14.000000', '1995-01-18 00:00:00.000000', 'muller.rody@gmail.com', 'Male', 'Rody Muller', '0379595471', '2024-06-30 03:49:14.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('f41dc4bf-b79d-419c-95fe-b5416067a28a', 'P8122366', '2024-07-09 02:45:10.000000', '2001-07-14 00:00:00.000000', 'paulalche@gmail.com', 'Male', 'Paul Alchemist', '0331578969', '2024-07-09 02:45:10.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `memberships`
--

CREATE TABLE `memberships` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price_month` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `thumbnail` text DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `memberships`
--

INSERT INTO `memberships` (`id`, `created_at`, `description`, `name`, `price_month`, `status`, `thumbnail`, `updated_at`) VALUES
('4e40642a-4b9c-4037-8f70-66101ff3404f', '2024-06-28 17:11:12.000000', 'A perfect start for your fitness journey with essential benefits.', 'Classic', 20, 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-ivan-samkov-4162451.jpg?alt=media&token=c7d1de15-a9fc-4a0a-aa1a-f35bdd8cb502', '2024-07-03 02:44:12.000000'),
('67490d7b-6c93-45a5-b504-c85277090a6b', '2024-06-28 17:12:41.000000', 'Elevate your fitness experience with enhanced access and services.', 'VIP', 35, 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-pixabay-416809.jpg?alt=media&token=723b8160-66fd-4c00-8c63-bd16b6144bff', '2024-06-28 17:12:41.000000'),
('a64eb49c-e817-4732-86ce-89c8b1ec3bc0', '2024-06-28 17:14:06.000000', 'Enjoy the ultimate fitness package with exclusive perks and privileges.', 'Premium', 50, 'Active', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fpexels-scottwebb-136405.jpg?alt=media&token=cbbce02d-e427-49c5-b2f7-1145fcb64eff', '2024-06-28 17:14:06.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `membership_benefits`
--

CREATE TABLE `membership_benefits` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `benefit_id` varchar(255) DEFAULT NULL,
  `membership_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `membership_benefits`
--

INSERT INTO `membership_benefits` (`id`, `created_at`, `updated_at`, `benefit_id`, `membership_id`) VALUES
('0d8915e4-7976-48e8-be21-c542b0309cf2', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '8e644393-4ac8-4c2f-b869-2575f93fd829', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0'),
('23b8a4b0-ac26-426a-9861-82227bbcf819', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', 'a6608940-5fe4-40d2-85a4-8cbb011c71ed', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0'),
('39110080-787a-4cd3-b023-c430c8f75366', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '2d6d5691-b474-43c2-899f-1cce12d3c420', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0'),
('47849080-70d3-4a8d-8dfd-69786e45057b', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '40df6d9d-d2b0-4589-a2eb-81ef0d8687b8', '67490d7b-6c93-45a5-b504-c85277090a6b'),
('4a4c9fa6-f37e-4405-bbd0-7bcc16ae8963', '2024-06-28 18:07:15.000000', '2024-06-28 18:07:15.000000', '1643631b-76c3-4ada-bcbc-19af7e9d436d', '67490d7b-6c93-45a5-b504-c85277090a6b'),
('4abb9a6a-0cfb-4499-8c63-619268afb45b', '2024-06-28 18:06:29.000000', '2024-06-28 18:06:29.000000', '7d671633-3482-4a79-ae7e-6b8767109574', '4e40642a-4b9c-4037-8f70-66101ff3404f'),
('6968c017-74ad-4ccd-9562-da112ee1afbe', '2024-07-10 09:03:04.000000', '2024-07-10 09:03:04.000000', 'a6608940-5fe4-40d2-85a4-8cbb011c71ed', '4e40642a-4b9c-4037-8f70-66101ff3404f'),
('71b26872-4952-4280-992a-953e975c13a7', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '8e644393-4ac8-4c2f-b869-2575f93fd829', '67490d7b-6c93-45a5-b504-c85277090a6b'),
('828ea636-8dc0-4991-9c76-84481d01dd14', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '7d671633-3482-4a79-ae7e-6b8767109574', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0'),
('9866ae90-fd20-4a6e-bece-7d9ff789158e', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '897a0c8b-6978-45d4-b99c-dda4530c242c', '67490d7b-6c93-45a5-b504-c85277090a6b'),
('bf9a1bc1-b696-415a-8495-e4ee8ed215bd', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '1643631b-76c3-4ada-bcbc-19af7e9d436d', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0'),
('dcfcc8ae-ef9a-4825-9318-bf9b7f43348a', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '8e644393-4ac8-4c2f-b869-2575f93fd829', '4e40642a-4b9c-4037-8f70-66101ff3404f'),
('ecba3418-a662-4682-946e-82d14481f302', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '897a0c8b-6978-45d4-b99c-dda4530c242c', '4e40642a-4b9c-4037-8f70-66101ff3404f'),
('f8c010da-5190-41e8-bdc2-bef15213fe38', '2024-06-28 18:06:30.000000', '2024-06-28 18:06:30.000000', '2d6d5691-b474-43c2-899f-1cce12d3c420', '67490d7b-6c93-45a5-b504-c85277090a6b');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member_registration_transfers`
--

CREATE TABLE `member_registration_transfers` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL,
  `membership_id` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `member_registration_transfers`
--

INSERT INTO `member_registration_transfers` (`id`, `created_at`, `dob`, `email`, `end_date`, `gender`, `name`, `phone`, `start_date`, `status`, `updated_at`, `gym_id`, `membership_id`, `amount`) VALUES
('0a26f615-63c9-4b8e-9b33-0e4a55bb44fa', '2024-07-09 01:07:54.000000', '1996-01-24 00:00:00.000000', 'raul.sergio@gmail.com', '2025-01-10 00:00:00.000000', 'Male', 'Sergio Raul', '0312795981', '2024-07-10 00:00:00.000000', 'Approved', '2024-07-09 01:07:54.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', 300),
('1', '2024-06-29 15:13:59.000000', '1998-03-19 15:13:59.000000', 'jack12henry@gmail.com', '2024-10-30 07:00:59.000000', 'Male', 'Jack Henry', '0359849556', '2024-06-30 07:00:59.000000', 'Approved', '2024-06-29 15:13:59.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', '67490d7b-6c93-45a5-b504-c85277090a6b', 140),
('141a3bb2-3faa-4725-912d-56afb9729436', '2024-07-11 11:44:18.000000', '2002-06-23 00:00:00.000000', 'lanngoc@gmail.com', '2024-12-12 00:00:00.000000', 'Female', 'Duong Lan Ngoc', '0337912791', '2024-07-12 00:00:00.000000', 'Pending', '2024-07-11 11:44:18.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', '67490d7b-6c93-45a5-b504-c85277090a6b', 175),
('3596ef70-9819-4149-bd61-402a3487dcda', '2024-07-10 08:59:02.000000', '1997-07-28 00:00:00.000000', 'b.tranvan@gmail.com', '2024-10-11 00:00:00.000000', 'Male', 'Tran Van B', '0397156758', '2024-07-11 00:00:00.000000', 'Approved', '2024-07-10 08:59:02.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', '4e40642a-4b9c-4037-8f70-66101ff3404f', 60),
('3ea7be04-6c72-4a78-8ebe-32c333550d2d', '2024-07-09 03:14:49.000000', '1997-01-23 00:00:00.000000', 'josh.moore@gmail.com', '2024-11-10 00:00:00.000000', 'Male', 'Joshua Moore', '0348756125', '2024-07-10 00:00:00.000000', 'Approved', '2024-07-09 03:14:49.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', '67490d7b-6c93-45a5-b504-c85277090a6b', 140);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member_services`
--

CREATE TABLE `member_services` (
  `id` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `is_sent_mail` int(11) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `coach_id` varchar(255) DEFAULT NULL,
  `member_id` varchar(255) DEFAULT NULL,
  `workout_service_id` varchar(255) DEFAULT NULL,
  `pt_service_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `member_services`
--

INSERT INTO `member_services` (`id`, `amount`, `created_at`, `end_date`, `is_sent_mail`, `start_date`, `status`, `updated_at`, `coach_id`, `member_id`, `workout_service_id`, `pt_service_id`) VALUES
('01ef42a6-efd3-4433-bdf0-49111a77296a', 80, '2024-07-11 11:42:08.000000', '2024-07-11 00:00:00.000000', 0, '2024-03-11 00:00:00.000000', 'Expired', '2024-07-11 11:42:08.000000', NULL, '33cfc744-91e0-47eb-b526-5f6dbe9e5a92', '4e40642a-4b9c-4037-8f70-66101ff3404f', NULL),
('051b49f8-ed7d-4502-9b42-4f719d76faca', 300, '2024-07-09 03:06:49.000000', '2025-01-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 03:06:49.000000', NULL, 'a0071df0-34f5-4c47-8cda-6b955f03f78f', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', NULL),
('0c456b74-ebb3-41cb-9cc9-6b6178eb2f81', 140, '2024-07-09 02:45:10.000000', '2024-11-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 02:45:10.000000', NULL, 'f41dc4bf-b79d-419c-95fe-b5416067a28a', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL),
('1313d4f4-5441-476e-bfff-4e347cdcc8b8', 7.33, '2024-06-30 03:31:18.000000', '2024-07-10 00:00:00.000000', 0, '2024-06-30 00:00:00.000000', 'Expired', '2024-06-30 03:31:18.000000', NULL, 'bdeb6f6b-2e71-4752-93a6-21c7aaa80903', '4e40642a-4b9c-4037-8f70-66101ff3404f', NULL),
('1e02f253-f791-453a-8918-047cb02a7710', 245, '2024-06-29 23:23:16.000000', '2024-08-11 00:00:00.000000', 0, '2024-06-30 07:00:59.000000', 'Active', '2024-06-29 23:23:16.000000', NULL, 'a05f0a89-3059-484f-aefc-122d97951aed', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL),
('22a1e1d4-2bd6-4576-bd72-2393919a94a8', 20, '2024-07-10 09:09:32.000000', '2024-08-10 00:00:00.000000', NULL, '2024-07-10 00:00:00.000000', 'Active', '2024-07-10 09:09:32.000000', NULL, '5172f6c6-3d94-4998-99c6-ac923d10b180', NULL, '0bd3cb08-a9d3-4fbb-8f79-df5ca40dcb40'),
('29953f36-adae-4207-bbd3-f41607fa0e6a', 80, '2024-07-11 11:44:37.000000', '2024-07-21 00:00:00.000000', 0, '2024-04-21 00:00:00.000000', 'Expiring Soon', '2024-07-11 11:44:37.000000', NULL, '52712bf2-c872-4ab3-a8ff-8520d66aca00', '4e40642a-4b9c-4037-8f70-66101ff3404f', NULL),
('2c7b6693-27ea-49a1-b5a7-d5ba01d17346', 150, '2024-07-09 02:41:14.000000', '2024-10-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 02:41:14.000000', NULL, 'd39ee1ad-a960-4092-86fb-9a12dc902167', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', NULL),
('35a26703-c889-4533-8194-7d7691c1103f', 60, '2024-07-03 03:30:30.000000', '2024-10-03 00:00:00.000000', 0, '2024-07-03 00:00:00.000000', 'Active', '2024-07-03 03:30:30.000000', NULL, 'a119d809-d24e-4643-bfb1-71e87ea03367', '4e40642a-4b9c-4037-8f70-66101ff3404f', NULL),
('36005357-01aa-472a-abf8-6d9cc91587aa', 35, '2024-07-11 16:54:07.000000', '2024-08-12 00:00:00.000000', 0, '2024-07-12 00:00:00.000000', 'Active', '2024-07-11 16:54:07.000000', NULL, '24efb7ae-a437-43b6-b2e2-c9ceb8316dd3', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL),
('5636e4a9-310f-414b-a5ca-eb78eaa7d5e5', 50, '2024-07-09 14:26:06.000000', '2024-10-09 00:00:00.000000', NULL, '2024-07-09 00:00:00.000000', 'Active', '2024-07-09 14:26:06.000000', '801f6d1d-d7c7-4767-b285-43bafc2d686c', 'ddaf4153-90d9-4939-b9f0-b70d37c33ca2', NULL, 'b0284856-df83-4488-88e6-be5d44af5d21'),
('623f4810-2b3c-4ae6-b618-cb67e77f6abb', 150, '2024-07-09 02:59:53.000000', '2024-10-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 02:59:53.000000', NULL, 'bfac707e-1086-4e93-94f0-3a6e2eb19517', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', NULL),
('6aaf497f-f451-4d8b-99da-c29be4324d0c', 150, '2024-06-30 03:49:14.000000', '2024-09-30 00:00:00.000000', 0, '2024-06-30 00:00:00.000000', 'Active', '2024-06-30 03:49:14.000000', NULL, 'ddaf4153-90d9-4939-b9f0-b70d37c33ca2', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', NULL),
('9a93b7c3-8310-463b-a54c-6776ff073aaf', 175, '2024-07-07 16:03:48.000000', '2024-12-07 00:00:00.000000', 0, '2024-07-07 00:00:00.000000', 'Active', '2024-07-07 16:03:48.000000', NULL, '9cd8ab7a-c56c-4011-95cf-840992e2fdec', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL),
('9bb4432f-1af7-4934-9e72-8a0cc08de452', 95.67, '2024-07-11 15:31:43.000000', '2024-09-30 00:00:00.000000', 0, '2024-07-11 15:31:43.000000', 'Active', '2024-07-11 15:31:43.000000', NULL, 'bdeb6f6b-2e71-4752-93a6-21c7aaa80903', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL),
('a5d050ec-8857-4e0e-be0b-af4b04f02edc', 200, '2024-07-11 14:26:54.000000', '2025-05-12 00:00:00.000000', 0, '2024-07-12 00:00:00.000000', 'Active', '2024-07-11 14:26:54.000000', NULL, 'db33e0bf-fca2-4424-9d56-173452da6248', '4e40642a-4b9c-4037-8f70-66101ff3404f', NULL),
('cd84f324-3d8d-49fc-baf6-aa7e6da8ec65', 20, '2024-07-09 14:27:36.000000', '2024-08-09 00:00:00.000000', NULL, '2024-07-09 00:00:00.000000', 'Active', '2024-07-09 14:27:36.000000', 'a1718422-0774-4079-b394-d24467bde6bf', '9cd8ab7a-c56c-4011-95cf-840992e2fdec', NULL, '0bd3cb08-a9d3-4fbb-8f79-df5ca40dcb40'),
('ce3ac839-19db-438e-8d63-6677e3de0bfb', 50, '2024-06-30 13:37:59.000000', '2024-10-01 00:00:00.000000', NULL, '2024-07-01 00:00:00.000000', 'Active', '2024-06-30 13:37:59.000000', '6769c773-9f37-48c0-aa63-d3aab5657b0c', 'a05f0a89-3059-484f-aefc-122d97951aed', NULL, 'b0284856-df83-4488-88e6-be5d44af5d21'),
('db3c304f-4e81-4631-97a0-4117325cd9c4', 200, '2024-07-09 02:53:58.000000', '2024-11-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 02:53:58.000000', NULL, 'c614dfc2-28d1-463b-8db8-503d5411a4cb', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', NULL),
('dfab9653-172c-4b55-931c-96951821b6b6', 300, '2024-07-09 14:18:57.000000', '2025-01-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 14:18:57.000000', NULL, '368505d2-4490-4bb7-adda-7fe18b5fe0b3', 'a64eb49c-e817-4732-86ce-89c8b1ec3bc0', NULL),
('e78158b6-6987-4436-bd6c-09fa16dada2a', 100, '2024-07-11 11:56:14.000000', '2025-01-11 00:00:00.000000', NULL, '2024-07-11 00:00:00.000000', 'Active', '2024-07-11 11:56:14.000000', NULL, 'bdeb6f6b-2e71-4752-93a6-21c7aaa80903', NULL, 'f302c4f3-4c18-4ff8-acb2-c83be4cbc871'),
('ec0dcbde-97d2-4657-8f00-33f98a741c8d', 140, '2024-07-09 14:18:47.000000', '2024-11-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 14:18:47.000000', NULL, '5172f6c6-3d94-4998-99c6-ac923d10b180', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL),
('f48f1786-c81f-4c19-9c8e-dca8690fe76c', 100, '2024-07-09 02:36:11.000000', '2024-12-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 02:36:11.000000', NULL, 'db2661c0-c9aa-4afc-b246-cd4f8d0bb9cd', '4e40642a-4b9c-4037-8f70-66101ff3404f', NULL),
('f6f14f32-f3ae-4e92-a6c2-5d4714018d1e', 20, '2024-07-03 03:32:13.000000', '2024-08-03 00:00:00.000000', NULL, '2024-07-03 00:00:00.000000', 'Active', '2024-07-03 03:32:13.000000', '6769c773-9f37-48c0-aa63-d3aab5657b0c', 'a119d809-d24e-4643-bfb1-71e87ea03367', NULL, '0bd3cb08-a9d3-4fbb-8f79-df5ca40dcb40'),
('f7fd37bb-6f4f-41cf-bb9e-33a9ceb29bf9', 350, '2024-07-09 03:12:05.000000', '2025-05-10 00:00:00.000000', 0, '2024-07-10 00:00:00.000000', 'Active', '2024-07-09 03:12:05.000000', NULL, 'b0b797b4-9dfd-4471-848f-98d9851b14fb', '67490d7b-6c93-45a5-b504-c85277090a6b', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `non_member_customers`
--

CREATE TABLE `non_member_customers` (
  `id` varchar(255) NOT NULL,
  `amount` double DEFAULT NULL,
  `check_in_time` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `non_member_customers`
--

INSERT INTO `non_member_customers` (`id`, `amount`, `check_in_time`, `created_at`, `name`, `phone`, `updated_at`, `gym_id`) VALUES
('114df581-4927-4a55-8ecb-91cae46b7a21', 6, '2024-07-11 11:43:22.000000', '2024-07-11 11:43:22.000000', 'Pham Van K', '0397122177', '2024-07-11 11:43:22.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('12b3f58d-96fa-413c-a822-c2ab0d7ed74f', 6, '2024-07-06 16:38:03.000000', '2024-07-06 16:38:03.000000', 'Manuel Niko', '0396716657', '2024-08-12 15:50:46.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('1752cf8e-1ee7-4a27-a645-9c61b664fd67', 6, '2024-07-03 02:04:07.000000', '2024-07-03 02:04:07.000000', 'Martin Demy', '0397746617', '2024-07-03 02:04:07.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('1b6eb18a-0b66-4059-b38a-60c4620b1417', 6, '2024-07-06 16:18:43.000000', '2024-07-06 16:18:43.000000', 'Mikel Mez', '0345456712', '2024-07-06 16:18:43.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('4ea32e1d-62b4-4179-936a-30fbd55277e5', 6, '2024-07-06 16:35:32.000000', '2024-07-06 16:35:32.000000', 'Tony', '0366721737', '2024-07-06 16:35:32.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('5c829776-20cf-418d-a1f3-6dcda7b7db11', 6, '2024-07-06 16:30:04.000000', '2024-07-06 16:30:04.000000', 'Felix Torres', '0397166120', '2024-07-06 16:30:04.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('5d4351d0-cb62-441e-bd4d-54f3f0b35bcc', 6, '2024-07-11 11:43:01.000000', '2024-07-11 11:43:01.000000', 'Le Duc Anh', '0379555677', '2024-07-11 11:43:01.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('5f2f80ad-52c7-4037-a215-4e965ef26ad0', 6, '2024-06-29 19:27:38.000000', '2024-06-29 19:27:38.000000', 'John Doe', '0397467516', '2024-06-29 19:27:38.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('829a0f26-5591-4ff7-8144-1eedd66ad968', 6, '2024-06-29 19:42:00.000000', '2024-06-29 19:42:00.000000', 'Lyly Sarah', '0394759674', '2024-06-29 19:42:00.000000', '0fd1e17c-28eb-4b47-9b80-821e8321a1e5'),
('ae34e822-511d-4dd7-a811-75e616729b48', 6, '2024-07-06 16:28:10.000000', '2024-07-06 16:28:10.000000', 'Joao Frank', '0379516167', '2024-07-06 16:28:10.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('aeb00156-e5ff-40bb-99be-fb32a6aee7cb', 6, '2024-07-06 16:21:08.000000', '2024-07-06 16:21:08.000000', 'Dani Ortiz', '0312975196', '2024-07-06 16:21:08.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('bb81a869-179c-45ab-b8c1-9ad0c5735a44', 6, '2024-07-10 08:57:09.000000', '2024-07-10 08:57:09.000000', 'Nguyen Van A', '0379576512', '2024-07-10 08:57:09.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('d00a3fbe-6c4c-46ed-a57c-57e3548cd2c2', 6, '2024-07-06 16:26:05.000000', '2024-07-06 16:26:05.000000', 'Lucas Hernandez', '0397595610', '2024-07-06 16:26:05.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('e81e8ab7-ecab-4d48-94ca-23873f828716', 6, '2024-06-29 19:42:29.000000', '2024-06-29 19:42:29.000000', 'Lan Anh Nguyen', '0379155764', '2024-06-29 20:09:45.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('ead97c6d-f917-481d-8dc0-26166ae054a9', 6, '2024-07-06 16:33:44.000000', '2024-07-06 16:33:44.000000', 'Tom Muller', '0397163165', '2024-07-06 16:33:44.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `personal_trainer_packages`
--

CREATE TABLE `personal_trainer_packages` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num_sessions` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `personal_trainer_packages`
--

INSERT INTO `personal_trainer_packages` (`id`, `created_at`, `duration`, `name`, `num_sessions`, `price`, `status`, `updated_at`) VALUES
('0bd3cb08-a9d3-4fbb-8f79-df5ca40dcb40', '2024-06-28 19:00:42.000000', 1, 'Beginner', 8, 20, 'Active', '2024-06-28 19:04:42.000000'),
('a31b0432-cfd5-417d-a633-c9c1cff17163', '2024-06-28 19:03:48.000000', 9, 'Pro', 60, 140, 'Active', '2024-06-28 19:05:31.000000'),
('b0284856-df83-4488-88e6-be5d44af5d21', '2024-06-28 19:01:05.000000', 3, 'Intermediate', 20, 50, 'Active', '2024-06-28 19:04:54.000000'),
('f302c4f3-4c18-4ff8-acb2-c83be4cbc871', '2024-06-28 19:03:29.000000', 6, 'Advanced', 40, 100, 'Active', '2024-06-28 19:05:20.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `revenues`
--

CREATE TABLE `revenues` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `membership_revenue` double DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `non_mem_revenue` double DEFAULT NULL,
  `pt_service_revenue` double DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `revenues`
--

INSERT INTO `revenues` (`id`, `created_at`, `membership_revenue`, `month`, `non_mem_revenue`, `pt_service_revenue`, `updated_at`, `year`, `gym_id`) VALUES
('3b8078db-e40d-450b-8add-c27cb17c1f54', '2024-06-30 13:07:50.000000', 220, 6, 24, 50, NULL, 2024, '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('d06335e7-74e6-478d-8ab7-57d98e284bab', '2024-07-03 03:30:30.000000', 2633, 7, 78, 210, NULL, 2024, '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trial_registrations`
--

CREATE TABLE `trial_registrations` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `preferred_date` datetime(6) DEFAULT NULL,
  `status_approve` varchar(255) DEFAULT NULL,
  `status_contact` varchar(255) DEFAULT NULL,
  `time_contact` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `trial_registrations`
--

INSERT INTO `trial_registrations` (`id`, `created_at`, `name`, `phone`, `preferred_date`, `status_approve`, `status_contact`, `time_contact`, `updated_at`, `gym_id`) VALUES
('03e7603d-f938-4652-8e44-db4a231f7d86', '2024-07-08 02:13:21.000000', 'Pablo Gavira', '0397651279', NULL, 'Pending', 'Uncontacted', '2:00 PM - 5:00 PM', '2024-07-08 02:13:21.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('1', '2024-06-23 00:25:55.000000', 'Remo Freuler', '0374954670', '2024-07-03 00:00:00.000000', 'Approved', 'Contacted', '9:00 AM - 12:00 PM', '2024-06-23 00:25:55.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('2a4f729e-6c80-47b4-a0e2-7cf5c679ec8b', '2024-07-09 03:13:05.000000', 'Isabella Garcia', '0349871205', '2024-07-11 00:00:00.000000', 'Pending', 'Contacted', '12:00 PM - 2:00 PM', '2024-07-09 03:13:05.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('4d6f91ad-71ed-42ec-b060-834d00c50ce0', '2024-07-09 00:28:26.000000', 'Hendrick', '0362728914', NULL, 'Approved', 'Uncontacted', '5:00 PM - 9:00 PM', '2024-07-09 00:28:26.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('59ff80ff-2fda-4aad-af7a-4077671ce548', '2024-07-08 01:37:50.000000', 'Kai Hardy', '0397651752', NULL, 'Pending', 'Uncontacted', '2:00 PM - 5:00 PM', '2024-07-08 01:37:50.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('ec3330b1-312c-4b82-90d5-ef9e13f2e5c8', '2024-07-08 02:05:41.000000', 'Rodrigo', '0317679622', '2024-07-10 00:00:00.000000', 'Approved', 'Contacted', '9:00 AM - 12:00 PM', '2024-07-08 02:05:41.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar` text DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` text DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `address`, `avatar`, `created_at`, `dob`, `email`, `full_name`, `password`, `phone`, `role`, `updated_at`, `gym_id`) VALUES
('1d8f449c-9f5e-4b0b-bb9b-7cd989c97d6e', '789 Oak St, Anytown USA', NULL, '2024-06-28 22:51:27.000000', '1992-07-20 00:00:00.000000', 'michael.johnson@example.com', 'Michael Johnson', '$2a$10$/EM1whG1QvECI/qz6xNXE.B4LE7wUhLqVmKcyKDsgl7i8lOaT7gO6', '0379377431', 'GYM_MANAGER', '2024-06-28 22:51:27.000000', '0fd1e17c-28eb-4b47-9b80-821e8321a1e5'),
('36dcdeeb-68aa-426e-af50-1994de32dd5d', '456 Elm St, Anytown USA', NULL, '2024-06-28 22:36:44.000000', '1990-10-10 00:00:00.000000', 'jane.smith@example.com', 'Jane Smith', '$2a$10$I9pYwagYL.0cIia8LjYHiOMnGAb1aOE9hRqBMrbrFyT3mUH3A7JX2', '0397457161', 'GYM_MANAGER', '2024-06-28 22:36:44.000000', '53681847-cff7-495b-82ab-47eff6008878'),
('6a8a4d8c-29ab-4801-a4a6-826cac50e883', '202 Birch St, Anytown USA', NULL, '2024-06-28 22:52:34.000000', '1988-03-25 00:00:00.000000', 'david.wilson@example.com', 'David Wilson', '$2a$10$v58ZwF2Eb9oJVf8TzaK2cuf9FxrTmHEDbG.ru0goQzy.RMiBiveWO', '0349716374', 'GYM_MANAGER', '2024-06-28 22:52:34.000000', '9843d92e-e539-4353-b5ea-1a52eea08444'),
('a2576afb-a55e-47a2-8eb3-9e9f8de24754', '303 Cedar St, Anytown USA', NULL, '2024-06-28 22:53:35.000000', '1988-08-05 00:00:00.000000', 'sarah.brown@example.com', 'Sarah Brown', '$2a$10$Jkn5x5vkv0oQJKCPPFj/MuCOGfQmSBbl2znAaEUP0Y8BlxKQHyxmC', '0379176126', 'GYM_MANAGER', '2024-06-28 22:53:35.000000', '60d6225b-e81e-4b08-937e-279612300898'),
('b2512e97-c169-4b0c-9790-8d5af6007085', '101 Pine St, Anytown USA', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F3a416e3bc1acd2ef7002eaa2d22a3df5_IYDR.jpg?alt=media&token=947dcc32-1786-4bc6-9fed-8341b379e199', '2024-06-28 22:54:29.000000', '1997-03-28 00:00:00.000000', 'a.nguyenvan@gmail.com', 'Nguyen Van A', '$2a$10$6.SBmW1XcTrTa3hEeb6d1.pcfq9YIrzoKvXogmozMUgmcgxZi8peW', '0358462155', 'GYM_MANAGER', '2024-06-28 22:54:29.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6'),
('cb000c2f-224a-438c-bdaf-6c68a19b548c', '63/26 Tran Quoc Vuong, Hanoi', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2Fmeongu.jpg?alt=media&token=f5b60639-410f-4201-af0d-d71af1a3538b', '2024-06-25 15:55:00.000000', '2002-10-14 00:00:00.000000', 'lam2002ttb@gmail.com', 'Do Vu Tung Lam', '$2a$10$Rx/81yMVEG8NBnzc9K.9EOGN8NQrMX.4GKjBXH0DBcehEQJ2qgNAq', '0329850375', 'SENIOR_ADMIN', '2024-06-25 15:55:00.000000', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `workout_results`
--

CREATE TABLE `workout_results` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `image_url` text DEFAULT NULL,
  `measurement` text DEFAULT NULL,
  `num_weeks` int(11) DEFAULT NULL,
  `nutrition_plan` text DEFAULT NULL,
  `pre_issues` text DEFAULT NULL,
  `program_description` text DEFAULT NULL,
  `share_content` text DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `gym_id` varchar(255) DEFAULT NULL,
  `member_service_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `workout_results`
--

INSERT INTO `workout_results` (`id`, `created_at`, `description`, `image_url`, `measurement`, `num_weeks`, `nutrition_plan`, `pre_issues`, `program_description`, `share_content`, `updated_at`, `gym_id`, `member_service_id`) VALUES
('257746b1-c98d-4053-8ed9-ebb7a904c82a', '2024-07-09 14:28:07.000000', '', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2FPicture_1_Shyam_Kotecha%20cover.png?alt=media&token=da9e9718-e8ea-440d-a3e2-f66042bd56c8', '[]', 5, '', '<p>Flat foot syndrome due to wearing shoes a lot causes difficulty in lower body exercises, especially squats.</p>', '', '', '2024-07-09 14:28:07.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', 'cd84f324-3d8d-49fc-baf6-aa7e6da8ec65'),
('4688d902-2d21-4f45-aa18-caf835c75c29', '2024-07-09 14:27:08.000000', '', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2FPicture_1_Adam_Goff%20cover.png?alt=media&token=a816787d-acc3-4d63-a617-754aaa849238', '[]', 14, '', '<p>Gaining a lot of weight but with a large concentration of fat in the abdomen, causing her to have the initial signs of back sagging (LCS). Buttocks, abdomen (weak, need to be strengthened) &gt;&lt; Lower back and hips (contraction, strong, need to stretch)</p>', '', '', '2024-07-09 14:27:08.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', '5636e4a9-310f-414b-a5ca-eb78eaa7d5e5'),
('e6aed904-6a0c-4b70-a598-bc9442283b12', '2024-07-09 14:29:18.000000', '', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F63b54f99aae4e.png?alt=media&token=22a18d07-f1ad-4866-a300-dad878b3b357', '[]', 14, '', '<p>sdsdhsh</p>', '', '', '2024-07-09 14:29:18.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', 'ce3ac839-19db-438e-8d63-6677e3de0bfb'),
('f33716ee-2617-4fc3-878c-3317824dcb1e', '2024-07-03 03:37:50.000000', 'After the training process, Emily was able to achieve the goal he had set, which was to gain weight and improve his health. Not only that, but the muscle groups that were previously weak, such as the arms, shoulders, and back, have also become much stronger.', 'https://firebasestorage.googleapis.com/v0/b/datn-fa8ff.appspot.com/o/images%2F6293576c24dfb.png?alt=media&token=7d18330a-6c36-4ca4-bc3a-ecaec704c7eb', '[{\"key\":\"Weight\",\"before\":\"52\",\"after\":\"47.8\",\"unit\":\"kg\"},{\"key\":\"Bodyfat\",\"before\":\"23.7\",\"after\":\"15.7\",\"unit\":\"%\"},{\"key\":\"Belly\",\"before\":\"82\",\"after\":\"70\",\"unit\":\"cm\"},{\"key\":\"Waist\",\"before\":\"74\",\"after\":\"63\",\"unit\":\"cm\"},{\"key\":\"Butt\",\"before\":\"86\",\"after\":\"90\",\"unit\":\"cm\"},{\"key\":\"Thigh\",\"before\":\"46.5\",\"after\":\"46\",\"unit\":\"cm\"}]', 5, '<p>First stage: Low Carb diet, Macro: ( 15 /…/… )(C/F/P) Don\'t completely cut out starch because she still works and her body needs a lot of energy to exercise. Eating too little can cause the body to fall into a life-sustaining state without losing weight. Instruct her on how to choose low GI starch sources such as sweet potatoes plus green vegetables, leafy vegetables are also sources of starch, help her eat more meat by eating starch at the beginning of the meal and at the end of the meal to reduce her appetite and then increase her appetite. Gradually increasing the amount of carbs to 20%, 25%, increasing to 5% in one phase, making her body get used to pushing carbs in.</p><p>Phase 2: Switch back to ModrateCarb, Macro: 30 / 40 / 30 eat healthy.</p>', '<ul><li>Emily is an office worker. The nature of her work plus a long period of time away from exercise caused her to gain weight rapidly on the first day of returning to exercise with a height of 1m58 and weight of 65.3 kg.</li><li>Flat foot syndrome due to wearing shoes a lot causes difficulty in lower body exercises, especially squats.</li><li>Gaining a lot of weight but with a large concentration of fat in the abdomen, causing her to have the initial signs of back sagging (LCS). Buttocks, abdomen (weak, need to be strengthened) &gt;&lt; Lower back and hips (contraction, strong, need to stretch)</li></ul>', '<p>Phase 1: GBC 3 sessions / 1 week. Weightlifting (50%) re-familiarizes yourself with movement and re-learns exercise techniques. At the end of the session there will be strong women cadio (50%).</p><p>Phase 2: GBC Full body training schedule 4 sessions/week. Running more non-training sessions with a coach improved her ability and spirit to practice.</p><p>Phase 3: U - L: 4 sessions / 1 week: optimize muscle development with 2 U sessions and 2 L sessions.</p>', 'Coming to Eaglefit has made me have more knowledge not only about exercises but also about internal transformation. I learned how to maintain and regain energy if I participate in drinking parties with colleagues or entertain guests that I cannot refuse. I\'m no longer conservative because I used to practice, but after practicing, I found that I still had a lot of gaps and practiced wrongly. Currently, my body is very good, I am more confident, my work relationships with colleagues and friends are all better.', '2024-07-03 16:55:01.000000', '7f930c50-d031-418f-8036-bc8bf7851ba6', 'f6f14f32-f3ae-4e92-a6c2-5d4714018d1e');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `benefits`
--
ALTER TABLE `benefits`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `brand_infos`
--
ALTER TABLE `brand_infos`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh5by19d0jv86tfmqru9hdoack` (`category_id`),
  ADD KEY `FK28p9xb2l2q3u0s3gxlchv0i4y` (`coach_id`),
  ADD KEY `FKpk372g1kilb3norls9bv2pn7e` (`gym_id`);

--
-- Chỉ mục cho bảng `class_categories`
--
ALTER TABLE `class_categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `class_members`
--
ALTER TABLE `class_members`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK72on5wi5b6ba3ciup6o7ap1h1` (`class_id`),
  ADD KEY `FKbq8r7gihgxrupbrun3rod48bn` (`member_id`);

--
-- Chỉ mục cho bảng `coaches`
--
ALTER TABLE `coaches`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrc1c90kvuxcygwavuvwnj74rb` (`gym_id`);

--
-- Chỉ mục cho bảng `coach_schedules`
--
ALTER TABLE `coach_schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3l3sb0mdmjibm2j304sk641i8` (`class_id`),
  ADD KEY `FK5ai6g44t52bpbo1ved01nko2d` (`coach_id`),
  ADD KEY `FKfqyv9wt85mbmtmdd2slvn6c9i` (`member_service_id`);

--
-- Chỉ mục cho bảng `content_websites`
--
ALTER TABLE `content_websites`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `equipments`
--
ALTER TABLE `equipments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdixskgf6x9fat7boaubama1hk` (`category_id`),
  ADD KEY `FKirljxo7wo93fhbeygn6ehm58p` (`gym_id`);

--
-- Chỉ mục cho bảng `equipment_categories`
--
ALTER TABLE `equipment_categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `equipment_repairs`
--
ALTER TABLE `equipment_repairs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtfp6bxkekefkeci4ybfytjvnk` (`equipment_id`);

--
-- Chỉ mục cho bảng `exercise_categories`
--
ALTER TABLE `exercise_categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `exercise_libraries`
--
ALTER TABLE `exercise_libraries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKam57aev24hfh0mdpuk8qk57gb` (`category_id`);

--
-- Chỉ mục cho bảng `gyms`
--
ALTER TABLE `gyms`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq6ilkrakw75dgu4bfknklqdor` (`gym_id`);

--
-- Chỉ mục cho bảng `memberships`
--
ALTER TABLE `memberships`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `membership_benefits`
--
ALTER TABLE `membership_benefits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1rbwfmb8y0f8ct34yreabthss` (`benefit_id`),
  ADD KEY `FKc806u1qankkdofo85xo1wmdrh` (`membership_id`);

--
-- Chỉ mục cho bảng `member_registration_transfers`
--
ALTER TABLE `member_registration_transfers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkjr1c7xy9dfusx9cbfo3j0kys` (`gym_id`),
  ADD KEY `FKpa8ta6r4itdar1tjcmnetemt7` (`membership_id`);

--
-- Chỉ mục cho bảng `member_services`
--
ALTER TABLE `member_services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKry6jdvxh3edrsl4eestx44dqk` (`coach_id`),
  ADD KEY `FK716t0v27cviieii00ndr58bnu` (`member_id`),
  ADD KEY `FKtec5v3dglo2mj9j5mqua85pdc` (`workout_service_id`),
  ADD KEY `FKtbrr4o8gpqycmmrvx85l2ektr` (`pt_service_id`);

--
-- Chỉ mục cho bảng `non_member_customers`
--
ALTER TABLE `non_member_customers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjnjt5epck8njl56iefnm90jqb` (`gym_id`);

--
-- Chỉ mục cho bảng `personal_trainer_packages`
--
ALTER TABLE `personal_trainer_packages`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `revenues`
--
ALTER TABLE `revenues`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd6jx5fmn9uxempteirvcvawy7` (`gym_id`);

--
-- Chỉ mục cho bảng `trial_registrations`
--
ALTER TABLE `trial_registrations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg3cbe9tsw9vxl0s9okvqbl1r4` (`gym_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK61re4b3t50tt71ru6l5mld7c2` (`gym_id`);

--
-- Chỉ mục cho bảng `workout_results`
--
ALTER TABLE `workout_results`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcl3m7sdjjalpg4fqu4uowjwan` (`gym_id`),
  ADD KEY `FKmb50xytgigt71orc9viqvwder` (`member_service_id`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `FK28p9xb2l2q3u0s3gxlchv0i4y` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`id`),
  ADD CONSTRAINT `FKh5by19d0jv86tfmqru9hdoack` FOREIGN KEY (`category_id`) REFERENCES `class_categories` (`id`),
  ADD CONSTRAINT `FKpk372g1kilb3norls9bv2pn7e` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `class_members`
--
ALTER TABLE `class_members`
  ADD CONSTRAINT `FK72on5wi5b6ba3ciup6o7ap1h1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `FKbq8r7gihgxrupbrun3rod48bn` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`);

--
-- Các ràng buộc cho bảng `coaches`
--
ALTER TABLE `coaches`
  ADD CONSTRAINT `FKrc1c90kvuxcygwavuvwnj74rb` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `coach_schedules`
--
ALTER TABLE `coach_schedules`
  ADD CONSTRAINT `FK3l3sb0mdmjibm2j304sk641i8` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`),
  ADD CONSTRAINT `FK5ai6g44t52bpbo1ved01nko2d` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`id`),
  ADD CONSTRAINT `FKfqyv9wt85mbmtmdd2slvn6c9i` FOREIGN KEY (`member_service_id`) REFERENCES `member_services` (`id`);

--
-- Các ràng buộc cho bảng `equipments`
--
ALTER TABLE `equipments`
  ADD CONSTRAINT `FKdixskgf6x9fat7boaubama1hk` FOREIGN KEY (`category_id`) REFERENCES `equipment_categories` (`id`),
  ADD CONSTRAINT `FKirljxo7wo93fhbeygn6ehm58p` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `equipment_repairs`
--
ALTER TABLE `equipment_repairs`
  ADD CONSTRAINT `FKtfp6bxkekefkeci4ybfytjvnk` FOREIGN KEY (`equipment_id`) REFERENCES `equipments` (`id`);

--
-- Các ràng buộc cho bảng `exercise_libraries`
--
ALTER TABLE `exercise_libraries`
  ADD CONSTRAINT `FKam57aev24hfh0mdpuk8qk57gb` FOREIGN KEY (`category_id`) REFERENCES `exercise_categories` (`id`);

--
-- Các ràng buộc cho bảng `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `FKq6ilkrakw75dgu4bfknklqdor` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `membership_benefits`
--
ALTER TABLE `membership_benefits`
  ADD CONSTRAINT `FK1rbwfmb8y0f8ct34yreabthss` FOREIGN KEY (`benefit_id`) REFERENCES `benefits` (`id`),
  ADD CONSTRAINT `FKc806u1qankkdofo85xo1wmdrh` FOREIGN KEY (`membership_id`) REFERENCES `memberships` (`id`);

--
-- Các ràng buộc cho bảng `member_registration_transfers`
--
ALTER TABLE `member_registration_transfers`
  ADD CONSTRAINT `FKkjr1c7xy9dfusx9cbfo3j0kys` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`),
  ADD CONSTRAINT `FKpa8ta6r4itdar1tjcmnetemt7` FOREIGN KEY (`membership_id`) REFERENCES `memberships` (`id`);

--
-- Các ràng buộc cho bảng `member_services`
--
ALTER TABLE `member_services`
  ADD CONSTRAINT `FK716t0v27cviieii00ndr58bnu` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `FKry6jdvxh3edrsl4eestx44dqk` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`id`),
  ADD CONSTRAINT `FKtbrr4o8gpqycmmrvx85l2ektr` FOREIGN KEY (`pt_service_id`) REFERENCES `personal_trainer_packages` (`id`),
  ADD CONSTRAINT `FKtec5v3dglo2mj9j5mqua85pdc` FOREIGN KEY (`workout_service_id`) REFERENCES `memberships` (`id`);

--
-- Các ràng buộc cho bảng `non_member_customers`
--
ALTER TABLE `non_member_customers`
  ADD CONSTRAINT `FKjnjt5epck8njl56iefnm90jqb` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `revenues`
--
ALTER TABLE `revenues`
  ADD CONSTRAINT `FKd6jx5fmn9uxempteirvcvawy7` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `trial_registrations`
--
ALTER TABLE `trial_registrations`
  ADD CONSTRAINT `FKg3cbe9tsw9vxl0s9okvqbl1r4` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK61re4b3t50tt71ru6l5mld7c2` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`);

--
-- Các ràng buộc cho bảng `workout_results`
--
ALTER TABLE `workout_results`
  ADD CONSTRAINT `FKcl3m7sdjjalpg4fqu4uowjwan` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`),
  ADD CONSTRAINT `FKmb50xytgigt71orc9viqvwder` FOREIGN KEY (`member_service_id`) REFERENCES `member_services` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
