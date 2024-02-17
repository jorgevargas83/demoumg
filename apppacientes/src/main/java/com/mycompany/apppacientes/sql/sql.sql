/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  1214k
 * Created: 10/02/2024
 */
CREATE DATAVASE UMG;

CREATE TABLE PACIENTES(
    id integer AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) not null,
    telefono varchar(30)
)

