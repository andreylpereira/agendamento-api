# SWAGGER AGENDAMENTO

## **Método**: POST
## URL: "/api/auth/login"
### EXEMPLO OBJETO DE ENTRADA:
{
   "login": "admin",
   "senha": "12345"
}
### Efetuação de login por meio das credenciais de entrada.

<br><br>

## **Método**: POST
## URL: "/api/usuario/cadastrarUsuario"
### EXEMPLO OBJETO DE ENTRADA:
{
   "login": "ADMIN",
   "senha": "123456",
   "perfil": "ADMINISTRADOR",
   "nome": "admin"
   "email": "admin@administrador.com"
}
## Cria um novo usuário no sistema.

<br><br>

## **Método**: POST
## URL: "/api/usuario/cadastrarAdmin"
### ENTRADA DE STRING:
 1234567
## Irá criar a conta de admin e a senha será a string digitada.

<br><br>

## **Método**: GET
## URL: "/api/agenda"
### EXEMPLO PARAMETROS: 
* /api/agenda?data=2020-05-15&hora=14:30:15
* /api/agenda?data=2020-05-15
* /api/agenda?hora=14:30:15
* /api/agenda
## Retorna lista de agendamentos conforme parametros utilizados.

<br><br>

## **Método**: POST
## URL: "/api/agenda"
### EXEMPLO OBJETO DE ENTRADA:
{
   "data": "2020-05-15",
   "hora": "14:30:15",
   "titulo": "Empresa 1",
   "observacao": "Buscar lanchos",
   "contato": "(48) 9999-9999"
}

## Insere um agendamento no banco de dados.

<br><br>

## **Método**: PUT
## URL: "/api/agenda/{id}"
### PARAMETROS/ENTRADA: agenda_id
### EXEMPLO OBJETO DE ENTRADA:
{
   "data": "2020-05-15",
   "hora": "14:30:15",
   "titulo": "Empresa 1",
   "observacao": "Buscar lanchos",
   "contato": "(48) 9999-9999"
}
## Atualiza um agendamento no banco de dados.

<br><br>

## **Método**: DELETE
## URL: "/api/agenda/{id}"
### PARAMETROS/ENTRADA: agenda_id
## Remove o agendamento com o indice útilizado.
