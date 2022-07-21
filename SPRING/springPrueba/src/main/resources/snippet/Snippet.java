package snippet;

public class Snippet {
	spring.datasource.url=jdbc:mysql://localhost:3306/mf0493m
	spring.datasource.username=root
	spring.datasource.password=admin
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	
	spring.jpa.show-sql=true
	spring.jpa.hibernate.ddl-auto=update
	
	#create-drop: Recrea la base de datos al arrancar y la borra al terminar
	#create: Recrea la base de datos al arrancar
	#update: Mantiene los cambios en las clases propag�ndolos a la base de datos
	#validate: Comprueba que clases y base de datos est�n sincronizados
	#none
	
}

