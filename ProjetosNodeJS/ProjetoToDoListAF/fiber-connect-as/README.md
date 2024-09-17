# Escopo do Projeto - FiberConnect

## Objetivo Geral
Criar uma plataforma web para a FiberConnect, onde os clientes possam se cadastrar, solicitar serviços técnicos e agendar reparos de forma intuitiva, acompanhando o status dessas solicitações em um painel de controle.

## Objetivos Específicos
- Permitir que os clientes realizem o cadastro na plataforma.
- S istema de login para garantir que apenas clientes autenticados possam acessar o sistema.
- Criar uma interface amigável para solicitação de serviços técnicos e agendamentos.
- Desenvolver um sistema de agendamento de reparos com opções de datas e horários disponíveis.
- Fornecer um painel de controle para os clientes acompanharem suas solicitações de serviço e agendamentos.
- Utilizar **React** no frontend para uma experiência de usuário dinâmica e **MongoDB** para o armazenamento de dados.

## Objetivos SMART
- **Específico**: Desenvolver um site funcional que permita cadastro, login e solicitações de serviços técnicos para os clientes da FiberConnect.
- **Mensurável**: Lançar uma versão funcional em até 6 meses, com acompanhamento semanal do progresso.
- **Alcançável**: Equipe de desenvolvimento capacitada com prazos claros e recursos adequados.
- **Relevante**: Atender à necessidade da FiberConnect de oferecer um serviço eficiente e de fácil acesso para seus clientes.
- **Temporal**: Concluir o desenvolvimento da plataforma e colocá-la em operação em até 6 meses.

## Análise de Risco
1. **Risco Técnico**: Falhas no desenvolvimento da integração entre frontend e backend.
   - **Mitigação**: Revisões periódicas e testes durante o desenvolvimento.

2. **Risco de Prazo**: Atrasos no desenvolvimento ou na fase de testes.
   - **Mitigação**: Gerenciamento de cronograma com entregas semanais e feedback constante.

3. **Risco de Segurança**: Vulnerabilidades no sistema de login.
   - **Mitigação**: Implementação de boas práticas de segurança (**JWT**, HTTPS, criptografia de dados).

## Recursos Tecnológicos
- **React**: Utilizado para o frontend, garantindo uma interface de usuário dinâmica e responsiva, proporcionando uma boa experiência ao cliente ao navegar pela plataforma.
- **Node.js**: Usado no backend para gerenciar a lógica do servidor, lidar com as solicitações dos usuários e comunicação com o banco de dados.
- **MongoDB**: Banco de dados NoSQL, escolhido pela sua flexibilidade e escalabilidade, permitindo o armazenamento eficiente de informações de usuários, serviços e agendamentos.
- **JWT (JSON Web Token)**: Implementado para autenticação e autorização de usuários, garantindo a segurança nas sessões e protegendo o acesso aos dados dos clientes.