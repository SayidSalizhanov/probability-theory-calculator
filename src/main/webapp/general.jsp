<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форма с несколькими кнопками</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .submit-button {
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: blue;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px; /* Отступ между кнопками */
        }
        .submit-button:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Выберите адрес для перехода</h2>
    <form action="/placementWithRepetition" method="get">
        <button type="submit" class="submit-button">Размещение с повторением</button>
    </form>

    <form action="/placementWithoutRepetition" method="get">
        <button type="submit" class="submit-button">Размещение без повторения</button>
    </form>

    <form action="/combinationWithRepetition" method="get">
        <button type="submit" class="submit-button">Сочетание с повторением</button>
    </form>

    <form action="/combinationWithoutRepetition" method="get">
        <button type="submit" class="submit-button">Сочетание без повторение</button>
    </form>

    <form action="/permutationsWithRepetition" method="get">
        <button type="submit" class="submit-button">Перестановка с повторением</button>
    </form>

    <form action="/permutationsWithoutRepetition" method="get">
        <button type="submit" class="submit-button">Перестановка без повторения</button>
    </form>

    <form action="/urnModel" method="get">
        <button type="submit" class="submit-button">Урновая модель</button>
    </form>
</div>

</body>
</html>