# 7.4 Parking Lot — Estacionamento

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Regras (como no livro):** o estacionamento tem vários níveis; cada vaga é de moto (`M`), compacta (`C`) ou grande
(`L`). Moto para em qualquer vaga; carro para em vaga compacta ou grande; ônibus precisa de **5 vagas grandes
consecutivas no mesmo nível**.

**Exercício:** `VehicleSize`, `Vehicle`, `Motorcycle`, `Car` e `Bus` já existem. Implemente `Solution.ParkingLot`:

* `new ParkingLot(String... levels)` — cada string descreve as vagas de um nível, em ordem (ex.: `"MMCCCLLLLL"`).
* `boolean parkVehicle(Vehicle v)` — estaciona na primeira posição válida (menor nível, menor índice); `false` se não
  houver lugar (ou se o veículo já estiver estacionado).
* `boolean removeVehicle(Vehicle v)` — libera as vagas; `false` se o veículo não estava estacionado.
* `int availableSpots()` — total de vagas livres.
