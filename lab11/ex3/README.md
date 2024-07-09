# Problema: 

Num sistema de chat existem determinados participantes, e, quando um envia uma mensagem, é suposto todos os outros (exceto o sender) receberem a mensagem que foi enviada. Sem utilizar um design pattern, seria necessário que cada participante tivesse uma referência direta para todos os outros, o que tornaria o código mais complexo e difícil de escalar. Qualquer mudança nos participantes exige, desta maneira, alterar o código existente

# Solução:

A solução para este problema passa pela implementação de um design pattern, mais especificamente o Mediator. Desta maneira, todas as mensagens iriam passar pelo mediator, e este iria reencaminhar as mesmas para todos os participantes, exceto para o que enviou a mensagem. Foi então criada a interface Mediator que contém os métodos sendMessage() e addPerson() e o ChatMediator que implementa essa interface, contendo um ArrayList com todas as pessoas presentes no chat

## Referências

- https://refactoring.guru/design-patterns/mediator