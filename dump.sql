-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.27 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Дамп структуры базы данных food2
CREATE DATABASE IF NOT EXISTS `food2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `food2`;

-- Дамп структуры для таблица food2.dish
CREATE TABLE IF NOT EXISTS `dish` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `src` longtext,
  `type` varchar(255) DEFAULT NULL,
  `calories` double NOT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы food2.dish: ~16 rows (приблизительно)
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
REPLACE INTO `dish` (`id`, `name`, `price`, `src`, `type`, `calories`, `weight`) VALUES
	(1, 'Гамбургер', 32, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354401/dishes/gamburger-removebg-preview_ajqhlg.png', 'FAST_FOOD', 0, 0),
	(2, 'Креветки', 245, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354400/dishes/pelmeniSOvojami-removebg-preview_hxuuhj.png', 'SEAFOOD', 0, 0),
	(32, 'Картошка фри', 125, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354402/dishes/free-potato-removebg-preview_tjnxfm.png', 'FAST_FOOD', 0, 0),
	(35, 'Картошка по-деревенски', 12, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354403/dishes/fired-potato_gl0new-removebg-preview_1_ocjm2c.png', 'GARNISH', 0, 0),
	(36, 'Шоколадное мороженое', 5, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354402/dishes/black-icecream-removebg-preview_fgrosz.png', 'DESERT', 0, 0),
	(37, 'Макароны ', 13, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354402/dishes/cheese-makaron-removebg-preview_q3jgin.png', 'GARNISH', 0, 0),
	(38, 'Огромное мороженое', 24, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354402/dishes/big-icecream-removebg-preview_d6vpvk.png', 'DESERT', 0, 0),
	(39, 'Рыбный суп', 12, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354402/dishes/fish-soup-removebg-preview_vyqhsg.png', 'SOUP', 0, 0),
	(40, 'Вишневый сок', 2, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354402/dishes/cherry-drink-removebg-preview_m6d8ou.png', 'DRINK', 0, 0),
	(41, 'Гренки с чесноком', 5, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354401/dishes/grenki-removebg-preview_tejiqb.png', 'FAST_FOOD', 0, 0),
	(42, 'Кетчуп', 1, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354401/dishes/ketchup-removebg-preview_xblixg.png', 'SAUCE', 0, 0),
	(43, 'Шаурма детская', 4, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354401/dishes/mini-shaverma-fastfood-removebg-preview_zok5j7.png', 'FAST_FOOD', 0, 0),
	(44, 'Минеральная вода', 5, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354401/dishes/mineral-water-removebg-preview_hsgyos.png', 'DRINK', 0, 0),
	(45, 'Мохито', 3, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354401/dishes/mohito-removebg-preview_kgik6p.png', 'DRINK', 0, 0),
	(46, 'Отбивная ', 15, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354400/dishes/potatowithchicken-garnish-removebg-preview_ltfgmg.png', 'MEAT', 0, 0),
	(47, 'Пицца', 1, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637354400/dishes/otbivnaya-removebg-preview_qlwxa6.png', 'BAKERY', 0, 0);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;

-- Дамп структуры для таблица food2.dish_has_ingredient
CREATE TABLE IF NOT EXISTS `dish_has_ingredient` (
  `ingredient_id` int NOT NULL,
  `dish_id` int NOT NULL,
  KEY `FKe3hw8vaa0usrjhayyr63s3y4j` (`dish_id`),
  KEY `FKnwkbrhx34wawl34w4177f7wn4` (`ingredient_id`),
  CONSTRAINT `FKe3hw8vaa0usrjhayyr63s3y4j` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`),
  CONSTRAINT `FKnwkbrhx34wawl34w4177f7wn4` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы food2.dish_has_ingredient: ~49 rows (приблизительно)
/*!40000 ALTER TABLE `dish_has_ingredient` DISABLE KEYS */;
REPLACE INTO `dish_has_ingredient` (`ingredient_id`, `dish_id`) VALUES
	(24, 1),
	(25, 1),
	(27, 1),
	(8, 2),
	(12, 2),
	(15, 2),
	(19, 2),
	(5, 32),
	(10, 32),
	(11, 32),
	(16, 32),
	(26, 32),
	(32, 32),
	(33, 32),
	(5, 35),
	(10, 35),
	(14, 35),
	(20, 35),
	(34, 36),
	(16, 37),
	(19, 37),
	(27, 37),
	(35, 37),
	(34, 38),
	(6, 39),
	(8, 39),
	(22, 39),
	(29, 39),
	(35, 39),
	(28, 40),
	(22, 41),
	(24, 41),
	(16, 42),
	(17, 42),
	(22, 42),
	(23, 42),
	(24, 42),
	(9, 43),
	(10, 43),
	(11, 43),
	(12, 43),
	(13, 43),
	(34, 44),
	(17, 45),
	(13, 46),
	(14, 46),
	(17, 46),
	(7, 47),
	(8, 47);
/*!40000 ALTER TABLE `dish_has_ingredient` ENABLE KEYS */;

-- Дамп структуры для таблица food2.ingredient
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calories` double DEFAULT NULL,
  `carbohydrates` double DEFAULT NULL,
  `fats` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `proteins` double DEFAULT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы food2.ingredient: ~31 rows (приблизительно)
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
REPLACE INTO `ingredient` (`id`, `calories`, `carbohydrates`, `fats`, `name`, `proteins`, `weight`) VALUES
	(5, 99, 24, 2.4, 'Мука', 1, 0),
	(6, 50, 0, 12, 'Окунь', 4.9, 0),
	(7, 10, 0.5, 0.5, 'Огурец', 1, 0),
	(8, 165, 14, 7.6, 'Молоко', 3.3, 0),
	(9, 124, 4.5, 7.5, 'Сметана', 1.3, 0),
	(10, 85, 0.5, 2.3, 'Майонез', 1.1, 0),
	(11, 175, 36, 13, 'Филе куриное', 25, 0),
	(12, 247, 23, 36, 'Крылышки куриные', 15, 0),
	(13, 273, 76, 43, 'Котлета свинная', 16, 0),
	(14, 23, 1, 0, 'Петрушка', 0, 0),
	(15, 323, 42, 54, 'Рулька свинная', 21, 0),
	(16, 1, 1, 0, 'Черный перец', 0, 0),
	(17, 1, 1, 0, 'Красный перец', 0, 0),
	(18, 14, 1, 2, 'Перец чили', 1, 0),
	(19, 123, 67, 14, 'Макароны', 12, 0),
	(20, 121, 24, 35, 'Картошка жаренная', 2, 0),
	(21, 111, 54, 23, 'Картошка варенная', 13, 0),
	(22, 1, 1, 0, 'Соль', 0, 0),
	(23, 1, 1, 0, 'Лук ', 0, 0),
	(24, 1, 2, 1, 'Чеснок', 0, 0),
	(25, 132, 13, 26, 'Сыр плавленный', 1.4, 0),
	(26, 127, 13, 43, 'Сыр 50%', 3, 0),
	(27, 43, 14, 7, 'Креветка', 16, 0),
	(28, 76, 15.9, 6.1, 'Креветка королевская', 16.9, 0),
	(29, 45, 0, 45, 'Окунь', 23, 0),
	(30, 53, 54, 12, 'Шампиньоны', 6, 0),
	(31, 143, 23, 34, 'Лисички жаренные', 1.3, 0),
	(32, 50, 5.6, 1.3, 'Помидоры', 2.2, 0),
	(33, 34, 34, 12, 'Кетчуп острый', 1.2, 0),
	(34, 184, 43, 19, 'Мороженое ванильное', 4.5, 0),
	(35, 24, 0, 2.1, 'Салат', 1, 0);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;

-- Дамп структуры для таблица food2.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numberOfBooking` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsgwj42spshwc3eestq5vk520j` (`user_id`),
  CONSTRAINT `FKsgwj42spshwc3eestq5vk520j` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы food2.orders: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
REPLACE INTO `orders` (`id`, `numberOfBooking`, `status`, `user_id`) VALUES
	(71, '0.0', 'INPROGRESS', 58);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп структуры для таблица food2.order_has_dish
CREATE TABLE IF NOT EXISTS `order_has_dish` (
  `order_id` int NOT NULL,
  `dish_id` int NOT NULL,
  KEY `FKkylv8savj3t209cj3tuj3k0cj` (`dish_id`),
  KEY `FKiatgw18mse1clylalbt1siw0l` (`order_id`),
  CONSTRAINT `FKiatgw18mse1clylalbt1siw0l` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKkylv8savj3t209cj3tuj3k0cj` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы food2.order_has_dish: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `order_has_dish` DISABLE KEYS */;
REPLACE INTO `order_has_dish` (`order_id`, `dish_id`) VALUES
	(71, 1),
	(71, 2),
	(71, 32);
/*!40000 ALTER TABLE `order_has_dish` ENABLE KEYS */;

-- Дамп структуры для таблица food2.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `block` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Дамп данных таблицы food2.user: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `block`, `email`, `name`, `password`, `role`, `sex`, `surname`, `username`) VALUES
	(58, 'UNBLOCK', '123admin123@mail.ru', 'Артём', '$2a$10$STglX9W.QyfesGR762DhXOfCBC5aYuZ.AHsQYdAUyHlOGQW8ty1ly', 'ADMIN', ' Мужчина', 'Рябцев', 'admin12345');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
