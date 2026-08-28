![](Logo_IFBA.png)

**ANÁLISE E DESENVOLVIMENTO DE SISTEMAS / SUPERIOR**

MARIA EDUARDA SODRÉ DE ARAÚJO

**DOCUMENTO DE ESPECIFICAÇÃO DE REQUISITOS**

Irecê / BA

2026

**CONTEÚDO**

**[1\. INTRODUÇÃO	3](#introdução)**

[1.1. Objetivo	3](#objetivo)

[1.2. Escopo do Produto	3](#escopo-do-produto)

[1.3. Definições, Acrônimos e Abreviações	3](#definições,-acrônimos-e-abreviações)

[**2\. DESCRIÇÃO GERAL	4**](#descrição-geral)

[2.1. Modo de Operação	4](#modo-de-operação)

[2.2. Funções do Produto	4](#funções-do-produto)

[2.3. Usuários e Sistemas Externos	5](#usuários-e-sistemas-externos)

[2.4. Restrições	5](#restrições)

[2.5. Requisitos Adiados	6](#requisitos-adiados)

[**3\. REQUISITOS ESPECÍFICOS	6**](#requisitos-específicos)

[3.1. Requisitos Funcionais	6](#requisitos-funcionais)

[3.2. Requisitos Não-Funcionais	7](#requisitos-não-funcionais)

[3.2.1. Desempenho	7](#desempenho)

[3.2.2. Usabilidade	7](#usabilidade)

[3.2.3. Segurança	8](#segurança)

[3.2.4. Expansibilidade	8](#expansibilidade)

[3.3. Requisitos de Interface	8](#requisitos-de-interface)

[3.3.1. Interfaces de Usuário	8](#interfaces-de-usuário)

[3.3.2. Interface de Hardware	9](#interface-de-hardware)

[3.3.3. Interface de Software	9](#interface-de-software)

[3.3.4. Interface de Comunicação	9](#interface-de-comunicação)

[**4\. RESTRIÇÕES E LIMITAÇÕES	9**](#restrições-e-limitações)

[**5\. GLOSSÁRIO	10**](#glossário)

[**6\. DIAGRAMA DE CASOS DE USO	11**](#diagrama-de-casos-de-uso)

| *Projeto: PsiConecta* *Data de Criação: 22 de Agosto de 2026* *Autor: Maria Eduarda Sodré de Araújo* |
| :---- |

1. ## **INTRODUÇÃO** {#introdução}

O PsiConecta tem como finalidade digitalizar e intermediar o contato entre psicólogos e pacientes, permitindo que o paciente localize profissionais cadastrados, estabeleça um vínculo de acompanhamento, se comunique por um canal de chat próprio da aplicação e registre seu humor diário de forma estruturada, enquanto o psicólogo gerencia seus vínculos e acompanha a evolução emocional de seus pacientes.

Público-alvo: Pacientes que buscam acompanhamento psicológico e desejam um canal de comunicação profissional e privado com seu psicólogo, e Psicólogos cadastrados que oferecem atendimento e acompanhamento aos pacientes vinculados.

1. ### **Objetivo** {#objetivo}

Este documento tem como objetivo apresentar de forma detalhada os requisitos funcionais e não funcionais do Sistema PsiConecta. Ele servirá como guia para o desenvolvimento do software, descrevendo as funcionalidades, características e necessidades que serão abordadas na implementação.

2. ### **Escopo do Produto** {#escopo-do-produto}

    O escopo deste documento abrange as funcionalidades e características do PsiConecta, desde o cadastro de pacientes e psicólogos, passando pela busca de psicólogos por proximidade, a solicitação e gestão do vínculo entre paciente e psicólogo, a comunicação via chat, o registro diário de humor do paciente (visível ao psicólogo vinculado) e o registro privado (visível apenas ao próprio paciente).

3. ### **Definições, Acrônimos e Abreviações** {#definições,-acrônimos-e-abreviações}

| Nº | Sigla | Definição |
| :---- | :---- | :---- |
| 01 | RF | Requisito funcional |
| 02 | RNF | Requisito não funcional |
| 03 | LGPD | Lei Geral de Proteção de Dados Pessoais |
| 04 | CRP | Conselho Regional de Psicologia |
| 05 | IDE | Integrated Development Environment (Ambiente de Desenvolvimento Integrado) |
| 06 | JVM | Java Virtual Machine (Máquina Virtual Java) |

## 

2. ## **DESCRIÇÃO GERAL** {#descrição-geral}

   1. ### **Modo de Operação** {#modo-de-operação}

    O PsiConecta opera como uma aplicação voltada à intermediação profissional entre psicólogos e pacientes, evitando o uso de canais pessoais (como WhatsApp) para esse contato. Ele visa interligar pacientes e psicólogos cadastrados, proporcionando um fluxo de busca, vínculo, comunicação e acompanhamento de humor mais organizado, privado e profissional. Os principais atores incluem o Paciente (busca, vínculo, registro de humor) e o Psicólogo (gestão de vínculos e acompanhamento dos registros).

2. ### **Funções do Produto** {#funções-do-produto}

| Função | Descrição |
| :---- | :---- |
| Cadastro de usuário | O paciente ou psicólogo pode se cadastrar informando dados pessoais e, no caso do psicólogo, dados profissionais (registro no CRP). |
| Busca de psicólogos | O paciente pode pesquisar os psicólogos cadastrados mais próximos, listados por proximidade. |
| Vínculo paciente-psicólogo | O paciente solicita vínculo com um psicólogo; o psicólogo pode aceitar ou recusar a solicitação. |
| Chat | Paciente e psicólogo vinculados trocam mensagens dentro da própria aplicação, sem uso de canais pessoais. |
| Registro de humor | O paciente registra diariamente seu humor em 5 estágios, descrevendo o que ocorreu naquele momento. |
| Registro privado | O paciente pode criar registros pessoais que não são compartilhados com o psicólogo vinculado. |

   3. ### **Usuários e Sistemas Externos** {#usuários-e-sistemas-externos}

| Usuário | Descrição |
| :---- | :---- |
| Paciente | Pessoa que busca acompanhamento psicológico, registra seu humor e se comunica com o psicólogo vinculado. |
| Psicólogo | Profissional cadastrado que gerencia seus vínculos, acompanha os registros de humor dos pacientes vinculados e se comunica via chat. |

   4. ### **Restrições** {#restrições}

| Nº | Tipo | Descrição |
| :---- | :---- | :---- |
| 01 | Software | O sistema deverá ser desenvolvido em linguagem Java, utilizando a IDE NetBeans e interface gráfica Swing. |
| 02 | Hardware | Computador com sistema operacional compatível com a Java Virtual Machine (JVM), sem dependência de hardware específico de dispositivos móveis. |
| 03 | Segurança | Registros de humor e mensagens de chat são dados sensíveis de saúde e devem ser armazenados de forma protegida, acessível apenas às partes autorizadas, em conformidade com a LGPD. |
| 04 | Segurança | O produto deverá restringir o acesso através de login individual para cada perfil de usuário. |
| 05 | Processo | O chat e a visualização dos registros de humor só ficam disponíveis dentro de um vínculo ativo entre paciente e psicólogo. |

   5. ### **Requisitos Adiados** {#requisitos-adiados}

| Nº | Referência | Detalhes |
| :---- | :---- | :---- |
| 01 | Histórico de evolução | Pacientes e psicólogos poderão acessar gráficos com a evolução do humor registrado ao longo do tempo. |
| 02 | Lembretes diários | O aplicativo poderá enviar notificações programadas lembrando o paciente de registrar seu humor do dia. |

3. ## **REQUISITOS ESPECÍFICOS** {#requisitos-específicos}

   1. ### **Requisitos Funcionais** {#requisitos-funcionais}

| Código | Nome | Descrição |
| :---- | :---- | :---- |
| RF01 | Cadastro de Usuário | O sistema deve permitir o cadastro de Paciente e Psicólogo, informando dados pessoais e, no caso do psicólogo, número de registro profissional (CRP). |
| RF02 | Busca de Psicólogos | O paciente deve poder pesquisar psicólogos cadastrados, organizados por proximidade, calculada a partir das coordenadas cadastradas de cada psicólogo. |
| RF03 | Solicitação de Vínculo | O paciente deve poder solicitar vínculo com um psicólogo de sua escolha. |
| RF04 | Gerenciamento de Vínculo | O psicólogo deve poder aceitar, recusar ou encerrar um vínculo com um paciente. |
| RF05 | Chat entre Vinculados | Paciente e psicólogo vinculados devem poder trocar mensagens de texto dentro da aplicação. |
| RF06 | Registro de Humor | O paciente deve poder registrar diariamente seu humor em 5 níveis, com uma descrição textual do contexto ou evento associado. |
| RF07 | Visualização de Registros pelo Psicólogo | O psicólogo deve poder visualizar os registros de humor dos pacientes vinculados a ele. |
| RF08  | Registro Privado | O paciente deve poder criar registros pessoais de humor que não são compartilhados com o psicólogo vinculado. |

   2. ### **Requisitos Não-Funcionais** {#requisitos-não-funcionais}

      1. #### **Desempenho** {#desempenho}

| Código  | Requisito / Aplicação | Descrição |
| :---- | :---- | :---- |
| RNF01  | Aplicação | O cálculo e a exibição dos psicólogos por proximidade devem ocorrer em tempo reduzido. |
| RNF02  | Aplicação | O envio e o recebimento de mensagens no chat devem ocorrer em tempo hábil, com atualização periódica das conversas. |

#### 

      2. #### **Usabilidade** {#usabilidade}

| Código  | Requisito / Aplicação | Descrição |
| :---- | :---- | :---- |
| RNF03  | Design intuitivo | O aplicativo deve possuir um design intuitivo e de fácil uso, tanto para o paciente quanto para o psicólogo. |
| RNF04  | Linguagem acessível no registro de humor | A tela de registro de humor deve utilizar linguagem simples e recursos visuais (ex.: ícones) para facilitar o preenchimento diário pelo paciente. |

#### 

      3. #### **Segurança** {#segurança}

| Código  | Requisito / Aplicação | Descrição |
| :---- | :---- | :---- |
| RNF05  | Autenticação segura | A autenticação segura deve ser implementada para acesso aos perfis de Paciente e Psicólogo. |
| RNF06  | Confidencialidade de dados sensíveis | Os registros de humor e as mensagens de chat devem ser acessíveis apenas ao paciente e ao psicólogo vinculado; os registros privados devem ser acessíveis somente ao próprio paciente. |

         #### 

      4. #### **Expansibilidade** {#expansibilidade}

| Código  | Requisito / Aplicação | Descrição |
| :---- | :---- | :---- |
| RNF07  | Arquitetura Modular | O sistema deve ser desenvolvido de forma modular, permitindo a futura adição de novas funcionalidades (ex.: agendamento de consultas) sem impacto nos módulos já existentes. |

   

   3. ### **Requisitos de Interface** {#requisitos-de-interface}

      1. #### **Interfaces de Usuário** {#interfaces-de-usuário}

| Nº | Nome | Descrição |
| :---- | :---- | :---- |
| 01 | Tela de cadastro | Janela Swing para o paciente ou psicólogo se cadastrar na aplicação. |
| 02 | Tela de busca | Janela Swing para o paciente pesquisar e listar psicólogos cadastrados, ordenados por proximidade. |
| 03 | Tela de chat | Janela Swing de troca de mensagens entre paciente e psicólogo vinculados. |
| 04 | Tela de registro de humor | Janela Swing para o paciente selecionar o nível de humor (5 estágios) e descrever o ocorrido. |
| 07 | Tela de login | Janela Swing para autenticação de Paciente e Psicólogo por login individual. |
| 05 | Painel do psicólogo | Janela Swing para o psicólogo visualizar os registros de humor dos pacientes vinculados. |
| 06 | Tela de registros privados | Janela Swing para o paciente criar e visualizar seus registros pessoais. |

      2. #### **Interface de Hardware** {#interface-de-hardware}

    Não aplicável no escopo atual. O sistema é implementado como aplicação desktop, utilizando mouse e teclado como periféricos padrão, sem dependência de hardware específico de dispositivos móveis (GPS, câmera etc.).

3. #### **Interface de Software** {#interface-de-software}

    O sistema deve ser executado sobre a Java Virtual Machine (JVM), sendo desenvolvido na IDE NetBeans com interface gráfica Swing.

4. #### **Interface de Comunicação** {#interface-de-comunicação}

O sistema deve notificar o paciente, dentro da própria aplicação, sobre a resposta à solicitação de vínculo e sobre o recebimento de novas mensagens no chat.

4. ## **RESTRIÇÕES E LIMITAÇÕES** {#restrições-e-limitações}

* Caso o vínculo entre paciente e psicólogo não seja corretamente gerenciado pelo sistema, dados sensíveis de saúde mental podem ficar expostos a pessoas não autorizadas.

* A ausência de GPS habilitado no dispositivo do paciente pode limitar a precisão da busca de psicólogos por proximidade.

5. ## **GLOSSÁRIO** {#glossário}

| Termo | Definição |
| :---- | :---- |
| Vínculo | Relação estabelecida entre paciente e psicólogo, que habilita o uso do chat e a visualização dos registros de humor pelo psicólogo. |
| Registro de Humor | Anotação diária do estado emocional do paciente, em 5 níveis, acompanhada de uma descrição do contexto. |
| Registro Privado | Anotação pessoal do paciente, não compartilhada com o psicólogo vinculado. |
| CRP | Conselho Regional de Psicologia, órgão responsável pelo registro profissional dos psicólogos. |
| LGPD | Lei Geral de Proteção de Dados Pessoais. |

6. ## **DIAGRAMA DE CASOS DE USO** {#diagrama-de-casos-de-uso}

    ![](diagrama_casos_uso_psiconecta.png)