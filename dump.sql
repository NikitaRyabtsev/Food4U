-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.35-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Дамп структуры для таблица food2.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numberOfBooking` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы food2.booking: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;

-- Дамп структуры для таблица food2.dish
CREATE TABLE IF NOT EXISTS `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `src` longtext,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы food2.dish: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` (`id`, `name`, `price`, `src`, `type`) VALUES
	(1, 'Гамбургер', 32, '/images/products/cheese-burger.png', 'FAST_FOOD'),
	(2, 'Креветки', 245, '/images/products/krevetki.png', 'SEAFOOD'),
	(7, 'Греческий салат', 76, '/images/products/greece-salad.png', 'SALAD'),
	(12, 'Пицца Маргарита', 67, '/images/products/meat-pizza.png', 'FAST_FOOD'),
	(13, 'Лазанья', 134, '/images/products/cheese-makaron.png', 'GARNISH'),
	(14, 'Шоколадное мороженое', 50, '/images/products/chocolate-icecream.png', 'BAKERY'),
	(15, 'Соус', 30, '/images/products/chilly.png', 'SAUCE'),
	(16, 'Яблочный сок', 30, '/images/products/apple-drink.png', 'DRINK');
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;

-- Дамп структуры для таблица food2.dish_has_ingredient
CREATE TABLE IF NOT EXISTS `dish_has_ingredient` (
  `ingredient_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  KEY `FKe3hw8vaa0usrjhayyr63s3y4j` (`dish_id`),
  KEY `FKnwkbrhx34wawl34w4177f7wn4` (`ingredient_id`),
  CONSTRAINT `FKe3hw8vaa0usrjhayyr63s3y4j` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`),
  CONSTRAINT `FKnwkbrhx34wawl34w4177f7wn4` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы food2.dish_has_ingredient: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `dish_has_ingredient` DISABLE KEYS */;
/*!40000 ALTER TABLE `dish_has_ingredient` ENABLE KEYS */;

-- Дамп структуры для таблица food2.ingredient
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calories` double DEFAULT NULL,
  `carbohydrates` double DEFAULT NULL,
  `fats` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `proteins` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы food2.ingredient: ~32 rows (приблизительно)
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` (`id`, `calories`, `carbohydrates`, `fats`, `name`, `proteins`, `weight`) VALUES
	(2, 94, 5, 23, 'Хлеб', 23, 12),
	(5, 99, 24, 2.4, 'Мука', 1, 25),
	(6, 50, 0, 12, 'Окунь', 4.9, 50),
	(7, 10, 0.5, 0.5, 'Огурец', 1, 10),
	(8, 165, 14, 7.6, 'Молоко', 3.3, 100),
	(9, 124, 4.5, 7.5, 'Сметана', 1.3, 20),
	(10, 85, 0.5, 2.3, 'Майонез', 1.1, 10),
	(11, 175, 36, 13, 'Филе куриное', 25, 100),
	(12, 247, 23, 36, 'Крылышки куриные', 15, 100),
	(13, 273, 76, 43, 'Котлета свинная', 16, 100),
	(14, 23, 1, 0, 'Петрушка', 0, 20),
	(15, 323, 42, 54, 'Рулька свинная', 21, 100),
	(16, 1, 1, 0, 'Черный перец', 0, 1),
	(17, 1, 1, 0, 'Красный перец', 0, 1),
	(18, 14, 1, 2, 'Перец чили', 1, 5),
	(19, 123, 67, 14, 'Макароны', 12, 100),
	(20, 121, 24, 35, 'Картошка жаренная', 2, 50),
	(21, 111, 54, 23, 'Картошка варенная', 13, 50),
	(22, 1, 1, 0, 'Соль', 0, 1),
	(23, 1, 1, 0, 'Лук ', 0, 1),
	(24, 1, 2, 1, 'Чеснок', 0, 3),
	(25, 132, 13, 26, 'Сыр плавленный', 1.4, 20),
	(26, 127, 13, 43, 'Сыр 50%', 3, 20),
	(27, 43, 14, 7, 'Креветка', 16, 50),
	(28, 76, 15.9, 6.1, 'Креветка королевская', 16.9, 50),
	(29, 45, 0, 45, 'Окунь', 23, 50),
	(30, 53, 54, 12, 'Шампиньоны', 6, 50),
	(31, 143, 23, 34, 'Лисички жаренные', 1.3, 20),
	(32, 50, 5.6, 1.3, 'Помидоры', 2.2, 50),
	(33, 34, 34, 12, 'Кетчуп острый', 1.2, 20),
	(34, 184, 43, 19, 'Мороженое ванильное', 4.5, 50),
	(35, 24, 0, 2, 'Салат', 1, 20);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;

-- Дамп структуры для таблица food2.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numberOfBooking` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsgwj42spshwc3eestq5vk520j` (`user_id`),
  CONSTRAINT `FKsgwj42spshwc3eestq5vk520j` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы food2.orders: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп структуры для таблица food2.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `block` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы food2.user: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
