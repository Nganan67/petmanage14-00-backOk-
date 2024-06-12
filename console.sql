-- 创建数据库pet_manage
CREATE DATABASE pet_manage;
use pet_manage;
-- 创建管理员表
CREATE TABLE admin (
                       admin_id INT AUTO_INCREMENT PRIMARY KEY,
                       admin_name VARCHAR(50) NOT NULL UNIQUE,
                       admin_password VARCHAR(50) NOT NULL,
                       admin_phone_number VARCHAR(20)
);
-- 创建用户表
CREATE TABLE user (
                      user_id INT AUTO_INCREMENT PRIMARY KEY,
                      user_name VARCHAR(50) NOT NULL UNIQUE,
                      user_password VARCHAR(50) NOT NULL,
                      user_phone_number VARCHAR(20)
);
-- 创建宠物表
CREATE TABLE pet (
                     pet_id INT AUTO_INCREMENT PRIMARY KEY,
                     pet_name VARCHAR(50) NOT NULL,
                     pet_breed VARCHAR(255),
                     pet_age INT,
                     pet_gender ENUM('男', '女'),
                     health_status VARCHAR(255),
                     adoption_status ENUM('未收养', '已收养'),
                     boarding_status ENUM('未寄养', '已寄养'),
                     owner_id INT,
                     FOREIGN KEY (owner_id) REFERENCES user(user_id)
);

-- 创建宠物房间表
CREATE TABLE pet_room (
                          room_id INT AUTO_INCREMENT PRIMARY KEY,
                          room_type VARCHAR(255),
                          capacity INT,
                          current_occupancy INT,
                          status ENUM('空闲', '占用')
);

-- 创建宠物用品表
CREATE TABLE pet_product (
                             product_id INT AUTO_INCREMENT PRIMARY KEY,
                             product_name VARCHAR(255) NOT NULL,
                             description TEXT,
                             price DECIMAL(10, 2) NOT NULL,
                             stock_quantity INT
);

-- 创建订单表
CREATE TABLE orders (
                        orders_id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT,
                        product_id INT,
                        quantity INT NOT NULL,
                        total_price DECIMAL(10, 2) NOT NULL,
                        order_status ENUM('待支付', '已支付', '已发货', '已完成'),
                        create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES user(user_id),
                        FOREIGN KEY (product_id) REFERENCES pet_product(product_id)
);
-- 使用pet_manage数据库
USE pet_manage;
-- 向管理员表添加数据
INSERT INTO admin (admin.admin_name, admin_password, admin_phone_number) VALUES
                                                          ('admin1', 'password1', '12345678901'),
                                                          ('admin2', 'password2', '23456789012');
-- 向用户表添加数据
INSERT INTO user (user_name, user.user_password, user_phone_number) VALUES
                                                         ('user1', 'password1', '12345678901'),
                                                         ('user2', 'password2', '23456789012');
-- 向宠物表添加数据
INSERT INTO pet (pet_name, pet_breed, pet.pet_age, pet_gender, health_status, adoption_status, boarding_status, owner_id) VALUES
                                                                                                          ('汪汪', '中华田园犬', 3, '男', '健康', '未收养', '未寄养', 1),
                                                                                                          ('喵喵', '中华田园猫', 2, '女', '良好', '已收养', '未寄养', 2);
-- 向宠物房间表添加数据
INSERT INTO pet_room (room_type, capacity, current_occupancy, status) VALUES
                                                                          ('中型犬房', 5, 2, '占用'),
                                                                          ('小型犬房', 10, 0, '空闲');
-- 向宠物用品表添加数据
INSERT INTO pet_product (product_name, description, price, stock_quantity) VALUES
                                                                               ('宠物食品', '高品质犬粮', 50.00, 100),
                                                                               ('宠物玩具', '耐咬磨牙球', 20.00, 50);
-- 向订单表添加数据
INSERT INTO orders (user_id, product_id, quantity, total_price, order_status) VALUES
                                                                                  (1, 1, 2, 100.00, '待支付'),
                                                                                  (2, 2, 1, 20.00, '已支付');