DROP TABLE IF EXISTS cursos;

<<<<<<< HEAD

=======
>>>>>>> 35157af14d2e7e82086a12acdc57846cfc714145
CREATE TABLE curso (
    idcurso INT AUTO_INCREMENT PRIMARY KEY,
    nombreCurso VARCHAR(255) NOT NULL,
    profesor VARCHAR(255) NOT NULL,
    asignaturas VARCHAR(255) NOT NULL
);

INSERT INTO curso (nombreCurso, profesor, asignaturas) VALUES
('Desarrollo Móvil', 'Carlos Ramírez', 'Flutter, Kotlin, Swift'),
('Inteligencia Artificial', 'Ana Torres', 'Machine Learning, Python, TensorFlow'),
('Redes de Computadores', 'Luis Martínez', 'TCP/IP, Routing, Switching'),
('Sistemas Operativos', 'Patricia Herrera', 'Linux, Windows, Procesos'),
('Seguridad Informática', 'Diego Silva', 'Criptografía, Pentesting, Firewalls'),
('Estructuras de Datos', 'Valeria Soto', 'Listas, Árboles, Grafos'),
('Desarrollo Backend', 'Javier Rojas', 'Java, Spring Boot, REST APIs');