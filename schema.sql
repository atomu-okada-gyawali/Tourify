-- MySQL dump 10.13  Distrib 8.0.37, for Win64 (x86_64)
--
-- Host: localhost    Database: Tourify
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `booking_date` date NOT NULL,
  `booking_hotel_yn` varchar(255) NOT NULL,
  `booking_room_num` int DEFAULT NULL,
  `booking_room_type` varchar(255) DEFAULT NULL,
  `tour_package_id` int NOT NULL,
  `traveller_id` int NOT NULL,
  `booking_status` varchar(255) DEFAULT NULL,
  `booking_guide` int DEFAULT NULL,
  `booking_transportation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fktour` (`tour_package_id`),
  KEY `fktraveller` (`traveller_id`),
  KEY `fkuser` (`booking_guide`),
  CONSTRAINT `fktour` FOREIGN KEY (`tour_package_id`) REFERENCES `tour_packages` (`tour_package_id`) ON DELETE CASCADE,
  CONSTRAINT `fktraveller` FOREIGN KEY (`traveller_id`) REFERENCES `travellers` (`traveller_id`) ON DELETE CASCADE,
  CONSTRAINT `fkuser` FOREIGN KEY (`booking_guide`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tour_packages`
--

DROP TABLE IF EXISTS `tour_packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_packages` (
  `tour_package_id` int NOT NULL AUTO_INCREMENT,
  `tour_package_destination` varchar(255) NOT NULL,
  `tour_package_price` int NOT NULL,
  `tour_package_night_no` int NOT NULL,
  `tour_package_itinerary` longblob,
  `tour_package_pamphlet` longblob,
  `tour_package_name` varchar(255) DEFAULT NULL,
  `trans_bus_price` int DEFAULT NULL,
  `trans_flight_price` int DEFAULT NULL,
  `hotel_phnumber` varchar(255) DEFAULT NULL,
  `hotel_twin_size_price` int DEFAULT NULL,
  `hotel_queen_size_price` int DEFAULT NULL,
  PRIMARY KEY (`tour_package_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `travellers`
--

DROP TABLE IF EXISTS `travellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travellers` (
  `traveller_id` int NOT NULL AUTO_INCREMENT,
  `traveller_name` varchar(255) NOT NULL,
  `traveller_email` varchar(255) NOT NULL,
  `traveller_phnumber` varchar(10) NOT NULL,
  `traveller_number` int NOT NULL,
  PRIMARY KEY (`traveller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_fname` varchar(255) NOT NULL,
  `user_lname` varchar(255) NOT NULL,
  `user_phnumber` varchar(10) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_role` varchar(255) NOT NULL,
  `user_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `unique_user_username` (`user_username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-16 10:49:27
