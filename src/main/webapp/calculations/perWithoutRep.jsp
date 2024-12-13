<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Форма для ввода данных</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .submit-button {
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: blue;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 50px; /* Отступ между кнопками */
        }
        .submit-button:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Перестановка без повторения</h2>

    <form action="/permutationsWithoutRepetition" method="post">
        <div class="form-group">
            <label for="totalItems">Количество предметов:</label>
            <input type="text" id="totalItems" name="totalItems">
        </div>
        <input type="submit" value="Отправить">
    </form>

    <c:if test="${not empty result}">
        <h3>Результат: ${result}</h3>
    </c:if>

    <form action="/general" method="get">
        <button type="submit" class="submit-button">Главная</button>
    </form>
</div>

</body>
</html>