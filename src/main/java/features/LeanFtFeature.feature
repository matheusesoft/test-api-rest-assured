# language: pt
Funcionalidade: C001 - Descrição da funcionalidada

  @C001_T001
  Cenario: C001_T001 - Criar vários livros em uma requisição POST
    Dado que executei o metodo DELETE para limpar toda a base
    Quando executo o metodo POST para os autores
     #| Nome              | Email                      | Dt Nascimento | Sobre                                 |
      | Ziraldo           | ziraldo@gmail.com          | 24/02/1950 | Autor, músico e escritor brasileiro   |
      | Louis Frankenberg | louisfrankenberg@gmail.com | 24/02/1979 | Economista e escritor norte americano |
    E executo o metodo POST para as categorias
     #| Nome     | Descrição                             |
      | Infantil | Literatura para crianças de 8-11 anos |
      | Finanças | Literatura para adultos               |
    E executo o metodo POST para os livros
     #| Título                | Qtd Páginas | Dt Lançamento | Autor             | Categoria | Qtd Estoque | Preço | ISBN        |
      | O Menino Maluquinho   |  48 | 26/08/2000 | Ziraldo           | Infantil |  8 | 11.99 | 55874445256 |
      | Seu Futuro Financeiro | 200 | 03/11/2008 | Louis Frankenberg | Finanças | 10 | 59.99 | 44484484848 |
    E executo o metodo GET para todos os livros
    Entao valido que o livro "O Menino Maluquinho" foi criado com o autor "Ziraldo" e a categoria "Infantil"
    E valido que o livro "Seu Futuro Financeiro" foi criado com o autor "Louis Frankenberg" e a categoria "Finanças"
    Entao valido que o livro "O Menino Maluquinho" tem estoque abaixo de "10"
    E valido que o preço do livro "Seu Futuro Financeiro" tem faixa entre "5.99" e "60.00"

  @C001_T002
  Cenario: C001_T002 - Buscar cliente e validar resposta
    Dado que executei o metodo GET para o livro "O Menino Maluquinho"
    Entao validar esquema do JSON "livro"
