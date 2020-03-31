# Agenda de Contatos Web (Back-End)

Esta é a configuração dos objetos e back-end do projeto Agenda de Contatos Web, onde possui as configurações de CRUD do projeto. Utilizando o Spring-Boot Java.

## Requisitos:

* Java 1.8 +
* Maven Apache 3.6.3 +


## Instalação 1.1:

1. Deverás instalar o Maven Apache em seu computador. Você pode fazer download neste link: https://maven.apache.org/download.cgi

##### Configurar o Maven Apache caso não possua (Windows): 

1. Fazer o download do maven em seu computador;
2. Extrair o arquivo no disco e diretório da sua preferência (recomendado Disco local C:);
3. Pesquise por "Alterar variáveis de ambiente" após encontrar, basta ir em variáveis de ambiente;
4. Criar uma nova variável de ambiente chamada: M2_HOME e colocar o caminho de onde você instalou o maven. Ex: C:\apache-maven-3.6.3
5. Ir em Path>Editar(canto direito);
6. Adicionar o caminho onde você instalou o maven adicionando o \bin. Ex: C:\apache-maven-3.6.3\bin

##### Configurar o Maven Apache caso não possua (Linux): 

1. Fazer o download do maven em seu computador;
2. Extrair o arquivo no disco e diretório da sua preferência;
3. Ir na pasta home do seu linux e habilitar para ver os arquivos ocultos.
4. Editar o arquivo: .bashrc;
5. No final do arquivo coloque: PATH=$:/diretorio-onde-salvou-o-maven;
6. Salvar o arquivo.

## Instalação 1.2:

1. Faça um clone deste projeto com este código:  git clone https://gitlab.com/Marcos_Piesske_Dev/agendaContatoSpring
2. Abra o terminal dentro do projeto clonado;
3. Dê o seguinte comando: mvn spring-boot:run

### OBS: Apenas o Back-End está funcioando, para fazer com que a interface funcione, deverás configurar o Front-End.

## Instalar o Front-End da aplicação:

1. Acessar o link: https://gitlab.com/Marcos_Piesske_Dev/agendaContatosFront
2. Seguir o passo a passo no REDME.md do repositório acima.
