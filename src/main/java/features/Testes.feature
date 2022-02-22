# language: pt
Funcionalidade: C001 - Descrição da funcionalidada

  @C001_T001
  Cenario: C001_T001 - Realizar uma requisição GET nos comentários
    Dado que executei o metodo GET para o comentario "alias odio sit"
    Quando valido o status code igual a 200
    Entao email do autor do comentario deve ser igual a "Lew@alysha.tv"

  @C001_T002
  Cenario: C001_T002 - Realizar uma requisição POST para criar um usuário
    Dado que executo o metodo POST para o user
     #| Nome                  | Username 		| Email 					|
      | Jose dos Santos   		|  josesantos | jose@gmail.com  |
    Quando valido o status code igual a 201
    Entao id gerado para o usuario e valido

  @C001_T003
  Cenario: C001_T003 - Realizar uma requisição PUT para alterar um usuário
    Dado que executo o metodo PUT para o user de id 5 alterando a lat para "38.33" e lng para "37.55"
    Quando valido o status code igual a 200
    Entao valido lat igual a "38.33" e lng igual "37.55"
