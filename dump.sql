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

-- Дамп данных таблицы food2.dish: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
REPLACE INTO `dish` (`id`, `name`, `price`, `src`, `type`, `calories`, `weight`) VALUES
	(1, 'Гамбургер', 32, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637257374/dishes/gamburger_zvlqwz.png', 'FAST_FOOD', 0, 0),
	(2, 'Креветки', 245, '/images/products/krevetki.png', 'SEAFOOD', 0, 0),
	(32, 'Пицца мясная', 125, 'https://res.cloudinary.com/finishhim123nik/image/upload/v1637257372/dishes/fish-soup_y18vuh.png', 'FAST_FOOD', 1, 1),
	(33, 'Пицца', 1, '/images/products/greece-salad.png', 'BAKERY', 1, 1),
	(34, 'Пицца', 1, '/images/products/greece-salad.png', 'BAKERY', 1, 1);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;

-- Дамп данных таблицы food2.dish_has_ingredient: ~14 rows (приблизительно)
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
	(33, 32);
/*!40000 ALTER TABLE `dish_has_ingredient` ENABLE KEYS */;

-- Дамп данных таблицы food2.ingredient: ~31 rows (приблизительно)
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
REPLACE INTO `ingredient` (`id`, `calories`, `carbohydrates`, `fats`, `name`, `proteins`, `weight`) VALUES
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
	(35, 24, 0, 2.1, 'Салат', 1, 20);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;

-- Дамп данных таблицы food2.orders: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп данных таблицы food2.order_has_dish: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `order_has_dish` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_has_dish` ENABLE KEYS */;

-- Дамп данных таблицы food2.user: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`id`, `block`, `email`, `name`, `password`, `role`, `sex`, `surname`, `username`) VALUES
	(58, 'UNBLOCK', '123admin123@mail.ru', 'Артём', '$2a$10$STglX9W.QyfesGR762DhXOfCBC5aYuZ.AHsQYdAUyHlOGQW8ty1ly', 'ADMIN', ' Мужчина', 'Рябцев', 'admin12345');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
