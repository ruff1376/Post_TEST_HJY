DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
    `no` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id` varchar(64) DEFAULT NULL UNIQUE,
    `title` varchar(100) NOT NULL,
    `writer` varchar(100) NOT NULL,
    `content` text,
    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
