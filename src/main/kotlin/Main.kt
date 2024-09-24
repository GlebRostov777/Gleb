/*import java.io.File

fun main() {
    // Укажите путь к вашему файлу
    //val filePath = "C:\\Users\\Ghost Smoke\\Downloads\\LILIANI-5-0134_03-05-2024_17-45-50.txt" // 1
    //val filePath = "C:\\Users\\Ghost Smoke\\Downloads\\LILIANI-5-1148_03-20-2024_12-08-37.txt" // 1465
    val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-0034_10-19-2023_12-50-00.2.txt" // 18948

    // Слово, которое мы будем искать в строках
    val searchWord = "Лилиани"
    var numberWord = 0
    try {
        // Чтение файла построчно
        File(filePath).forEachLine { line ->
            // Проверка, содержит ли строка искомое слово
            if (line.contains(searchWord)) {
                // Вывод строки
                println(line)
                numberWord += 1

            }
        }
        println("Количесвто слов \"$searchWord\" = $numberWord")
    } catch (e: Exception) {
        println("Произошла ошибка при чтении файла: ${e.message}")
    }
}
*/

/*
fun main() {
    // Ввод координат трех точек
    println("Введите координаты первой точки (x1, y1, z1):")
    val (x1, y1, z1) = readLine()!!.split(" ").map { it.toDouble() }

    println("Введите координаты второй точки (x2, y2, z2):")
    val (x2, y2 , z2) = readLine()!!.split(" ").map { it.toDouble() }

    //println("Введите координаты третьей точки (x3, y3):")
    //val (x3, y3) = readLine()!!.split(" ").map { it.toDouble() }

    // Проверка на движение
    val moved = (x1 != x2 || y1 != y2) || (z1 != z2)
    val delx = x2 - x1
    val dely = y2 - y1
    val delz = z2 - z1
    if (moved) {
        println("Бункер двигаеться.")
        println("На ${delx} см по оси Х")
        println("На ${dely} см по оси Y")
        println("На ${delz} см по оси Z")
        if (delx >= 50 || dely >= 50 || delz >= 50 ) {

        }
    } else {
        println("Точка не двигалась.")
    }
}
        val fileName = "C:\\Users\\Ghost Smoke\\Desktop\\123.txt"
*/

/*
import java.io.File

fun main() {
    val fileName = "C:\\Users\\Ghost Smoke\\Desktop\\123.txt"
    val lines = mutableListOf<List<Int>>()

    try {
        // Читаем файл и записываем строки в массив
        File(fileName).useLines { lineSequence ->
            lineSequence.take(10).forEach { line ->
                val numbers = line.split(" ").map { it.toInt() }
                lines.add(numbers)
            }
        }
        // Проверяем, что всего считали 10 строк
        if (lines.size != 10) {
            println("Недостаточно строк в файле. Необходимо 10 строк.")
            return
        }
        // Массив для хранения результата
        val result = mutableListOf<List<Int>>()

        for (i in 1 until lines.size) {
            val difference = lines[i].zip(lines[i - 1]) { a, b -> a - b }
            if (difference[0] >= 50 || difference[0] <= -50)
                print("Изменение по оси Х\t")
            else print("-\t")
            if (difference[1] >= 50 || difference[1] <= -50)
                print("Изменение по оси Y\t")
            else print("--\t")
            if (difference[2] >= 50 || difference[2] <= -50)
                print("Изменение по оси Z\t")
            else print("---\t")
            println()
            result.add(difference)
        }
        println()
        // Выводим результаты
            for (i in result.indices) {

            println("Результат вычитания ${i + 1}-й строки из ${i + 2}-й: ${result[i].joinToString(" ")}")
        }

    } catch (e: Exception) {
        println("Ошибка при чтении файла: ${e.message}")
    }
}*/

/*
import java.io.File

fun main() {
    val fileName = "C:\\Users\\Ghost Smoke\\Desktop\\123.txt"
    val lines = mutableListOf<List<Int>>()

    try {
        File(fileName).useLines { lineSequence ->
            lineSequence.take(11).forEach { line ->
                // Проверка на null и преобразование строки в список чисел
                val numbers = line.split(" ").mapNotNull { it.toIntOrNull() }
                // Добавляем только непустые списки
                if (numbers.isNotEmpty()) {
                    lines.add(numbers)
                }
            }
        }

        if (lines.size != 11) {
            println("Мало строк с данными")
            return
        }

        val result = mutableListOf<List<Int>>()
        for (i in 1 until lines.size) {
            val difference = lines[i].zip(lines[i - 1]) { a, b -> a - b }
            if (difference[0] >= 50 || difference[0] <= -50) print("Х\t") else print("-\t")
            if (difference[1] >= 50 || difference[1] <= -50) print("Y\t") else print("-\t")
            if (difference[2] >= 50 || difference[2] <= -50) print("Z\t") else print("-\t")
            println()
            result.add(difference)
        }

        println()
        for (i in result.indices) {
            println("Результат вычитания ${i + 1}-й строки из ${i + 2}-й: ${result[i].joinToString(" ")}")
        }
    } catch (e: Exception) {
        println("Ошибка ${e.message}")
    }
}
*/


/*
import java.io.File

fun main() {
    // Указываем имя файла и слово для поиска
    val fileName = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-0034_10-19-2023_12-50-00.2.txt"  // Замените на ваше имя файла
    val searchWord = "акселерометра"  // Замените на ваше слово

    // Открываем файл и читаем его построчно
    File(fileName).forEachLine { line ->
        if (line.contains(searchWord)) {
            // Если строка содержит искомое слово, находим числа после него
            val numbers = line.split(" ")
                .dropWhile { it != searchWord } // Пропускаем слова до искомого
                .drop(1) // Пропускаем само искомое слово

            // Считаем сумму чисел
            val sum = numbers
                .mapNotNull { it.toIntOrNull() } // Преобразуем строки в числа (игнорируем нечисловые)
                .sum()

            // Выводим результат
            println("Сумма чисел после слова '$searchWord': $sum")
        }
    }
}
*/

/*

import java.io.File
import kotlin.math.absoluteValue

fun main() {
    //val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-1148_03-20-2024_12-08-37.2.txt" // 1465
    //val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-0034_10-19-2023_12-50-00.2.txt" // 18948
    val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-0034_10-19-2023_11-08-09.2.txt"

    println("Введите искомое слово:")
    //val targetWord  = readlnOrNull() // Замените на слово, которое нужно найти
    val targetWord = "акселерометра" // Замените на слово, которое нужно найти

    // Читаем файл
    val fileContent = File(filePath).readLines()

    // Предполагаем, что сумма предыдущего значения равна 0
    var previousSum = 0L
    val targetWord2 = "Начало движения"


    for (line in fileContent) {
        // Ищем слово в строке
       if (targetWord2 in line){
            // Разбиваем строку на слова и находим числа
            val numbers = line.split(" ")
                .filter { it.toIntOrNull() != null } // Оставляем только числа
                .map { it.toInt() } // Преобразуем строки в числа
            println()
            println(line)
        }
        if (targetWord.toString() in line) {

            // Разбиваем строку на слова и находим числа
            val numbers = line.split(" ")
                .filter { it.toIntOrNull() != null } // Оставляем только числа
                .map { it.toInt() } // Преобразуем строки в числа

            // Суммируем найденные числа
            val list = numbers.toMutableList()
            list.removeFirst()

            val currentSum : Int = list.sum()

            val difference = (currentSum - previousSum).absoluteValue
            if (difference > 40) {
                println()
                println("Бункер двигался в момент: $line")
                println("Найдены числа: $list, их сумма: $currentSum")
                println("Разница между суммами $previousSum - $currentSum = $difference, больше 40")
                //println("Значительные изменения происходят в: \n$line ")
            }

            // Обновляем предыдущее значение суммы

            previousSum = currentSum.toLong()
        }

    }
}
*/



/*
import java.io.File
import kotlin.math.absoluteValue

fun main() {
    val inputFilePath = "C:\\\\Users\\\\Ghost Smoke\\\\Desktop\\\\LILIANI-5-0034_10-19-2023_11-08-09.txt"
    val outputFilePath = "C:\\\\Users\\\\Ghost Smoke\\\\Desktop\\\\LILIANI-5-0034_10-19-2023_11-08-09.2.txt" // Путь к выходному файлу
    val targetWord = "акселерометра" // Слово для поиска
    val symbolsToReplace = mapOf('(' to ' ', ')' to ' ') // Символы для замены
    var previousSum = 0
    // 1. Чтение файла и замена символов
    val originalText = File(inputFilePath).readText()
    val modifiedText = symbolsToReplace.entries.fold(originalText) { text, (oldChar, newChar) ->
        text.replace(oldChar, newChar)
    }
    File(outputFilePath).writeText(modifiedText)
    val fileContent = File(inputFilePath).readLines()

    for (line in fileContent) {
        if (targetWord.toString() in line) {

            // Разбиваем строку на слова и находим числа
            val numbers = line.split(" ")
                .filter { it.toIntOrNull() != null } // Оставляем только числа
                .map { it.toInt() } // Преобразуем строки в числа

            // Суммируем найденные числа
            val list = numbers.toMutableList()
            list.removeFirst()

            val currentSum: Int = list.sum()

            val difference = (currentSum - previousSum).absoluteValue
            if (difference > 40) {
                println()
                println("Бункер двигался в момент: $line")
                //println("Найдены числа: $list, их сумма: $currentSum")
                println("Разница между суммами больше 30: $difference")
                //println("Значительные изменения происходят в: \n$line ")
            }


            // Обновляем предыдущее значение суммы

            previousSum = currentSum
        }
    }

//    // 2. Поиск строк с определенным словом
//    val linesWithWord = modifiedText.lines().filter { it.contains(searchWord) }
//
//    // 3. Вычисление разницы между строками
//    for (i in 1 until linesWithWord.size) {
//        val firstLineValue = linesWithWord[i - 1].length // Здесь можно изменить на нужное значение
//        var secondLineValue = linesWithWord[i].length // Здесь можно изменить на нужное значение
//        val difference = secondLineValue - firstLineValue
//        val resultSign = if (difference > 50) "+" else "-"
//
//        // Вывод результата
//        println("Строка: '${linesWithWord[i]}' | Разница: $resultSign $difference")
//    }
}
 */

/*
import java.io.File

fun main() {
    // Путь к исходному файлу и файлу для записи измененного текста
    val inputFilePath = "D:\\.Работа\\Показания бункера\\LILIANI-5-0034_10-19-2023_12-50-00.2.txt"
    val outputFilePath = "C:\\Users\\Ghost Smoke\\Desktop\\132.txt"

    // Заменить определенные символы
    val replacements = mapOf('(' to ' ', ')' to ' ') // пример замены символов
    val modifiedText = File(inputFilePath).readText().map { replacements[it] ?: it }.joinToString("")

    // Записать измененный текст в другой файл
    File(outputFilePath).writeText(modifiedText)

    // Нахождение определенного слова и выполнение вычислений
    val keyword = "акселерометра" // замените на ваше слово для поиска
    val linesContainingKeyword = mutableListOf<String>()

    File(inputFilePath).forEachLine { line ->
        if (line.contains(keyword)) {
            linesContainingKeyword.add(line)
        }
    }

    // Получение только чисел из строк
    val numbers = linesContainingKeyword.map { line ->
        line.split("s+ ".toRegex()) // разбиваем строку на слова
            .filter { it.all { char -> char.isDigit() } } // оставляем только числа
            .map { it.toInt() } // преобразуем строки в Int
    }.flatten()

    // Вычисления
    val differences = mutableListOf<Pair<Int, String>>() // список для хранения значений разниц
    for (i in 1 until numbers.size) {
        val difference = numbers[i] - numbers[i - 1]
        val sign = if (difference > 50) "+" else "-"
        differences.add(Pair(difference, "$sign $difference"))
        println("Строка ${i + 2}: ${differences[i].second}")
    }

    // Вывод результатов
    for (i in differences.indices) {
        println("Строка ${i + 2}: ${differences[i].second}")
    }
}
*/

/*
import java.io.File

fun main() {
    // Путь к файлу
    val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-0034_10-19-2023_12-50-00.2.txt" // 18948
    // Определенные символы для удаления
    val charactersToRemove = listOf(',', '.', '!', '?', ';', ':', '"', '(', ')')

    // Чтение файла и удаление символов
    val originalContent = File(filePath).readText()
    val cleanedContent = charactersToRemove.fold(originalContent) { acc, char ->
        acc.replace(char.toString(), "")
    }

    // Разделение на строки и поиск нужного слова
    val keyword = "акселерометра" // Замените на ваше слово
    val linesWithKeyword = cleanedContent.lines().filter { it.contains(keyword) }

    // Заносим строки в массив (если найдено меньше 10, то заполним оставшиеся пустыми)
    val resultArray = Array(100) { if (it < linesWithKeyword.size) linesWithKeyword[it] else "" }

    // Проверка разностей строк
    for (i in 2 until resultArray.size) {
        if (resultArray[i].isNotEmpty() && resultArray[i - 1].isNotEmpty()) {
            val difference = resultArray[i].length - resultArray[i - 1].length
            if (difference > 4) {
                println("+")

            } else {
                println("-")
            }
        }
    }
}
*/


import java.io.File
import kotlin.math.absoluteValue

fun main() {
    change1()
    change2()
    change3()

    //val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-1148_03-20-2024_12-08-37.2.txt" // 1465
    //val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\LILIANI-5-0034_10-19-2023_12-50-00.2.txt" // 18948
    val filePath = "C:\\Users\\Ghost Smoke\\Desktop\\333.txt"

    //println("Введите искомое слово:")
    //val targetWord  = readlnOrNull() // Замените на слово, которое нужно найти
    val targetWord = "акселерометра" // Замените на слово, которое нужно найти

    // Читаем файл
    val fileContent = File(filePath).readLines()

    // Предполагаем, что сумма предыдущего значения равна 0
    var previousSum = 0L
    val targetWord2 = "Начало движения"


    for (line in fileContent) {
        // Ищем слово в строке
        if (targetWord2 in line){
            // Разбиваем строку на слова и находим числа
            val numbers = line.split(" ")
                .filter { it.toIntOrNull() != null } // Оставляем только числа
                .map { it.toInt() } // Преобразуем строки в числа
            println()
            println(line)
        }
        if (targetWord.toString() in line) {

            // Разбиваем строку на слова и находим числа
            val numbers = line.split(" ")
                .filter { it.toIntOrNull() != null } // Оставляем только числа
                .map { it.toInt() } // Преобразуем строки в числа

            // Суммируем найденные числа
            val list = numbers.toMutableList()
            list.removeFirst()

            val currentSum : Int = list.sum()

            val difference = (currentSum - previousSum).absoluteValue
            if (difference > 30) {
                println()
                println("Бункер двигался в момент: $line")
                println("Найдены числа: $list, их сумма: $currentSum")
                println("Разница между суммами $previousSum - $currentSum = $difference, больше 30")
                //println("Значительные изменения происходят в: \n$line ")
            }

            // Обновляем предыдущее значение суммы

            previousSum = currentSum.toLong()
        }
    }
}

fun change1() {
    val inputFilePath = "D:\\.Работа\\Показания бункера\\LILIANI-5-0034_10-19-2023_11-51-15.txt" // Путь к исходному файлу
    val outputFilePath = "C:\\Users\\Ghost Smoke\\Desktop\\111.txt" // Путь к выходному файлу
    val charToReplace = '(' // Символ, который нужно заменить
    val replacementChar = ' ' // Символ, на который нужно заменить
    // Читаем содержимое файла
    val inputFile = File(inputFilePath)
    // Заменяем символы
    val content = inputFile.readText()
    val modifiedContent = content.replace(charToReplace, replacementChar)
    // Сохраняем измененное содержимое в новый файл
    val outputFile = File(outputFilePath)
    outputFile.writeText(modifiedContent)
    println("Содержимое файла было изменено и сохранено в $outputFilePath.")
}
fun change2() {
    val inputFilePath = "C:\\Users\\Ghost Smoke\\Desktop\\111.txt" // Путь к исходному файлу
    val outputFilePath = "C:\\Users\\Ghost Smoke\\Desktop\\222.txt" // Путь к выходному файлу
    val charToReplace = ')' // Символ, который нужно заменить
    val replacementChar = ' ' // Символ, на который нужно заменить
    // Читаем содержимое файла
    val inputFile = File(inputFilePath)
    // Заменяем символы
    val content = inputFile.readText()
    val modifiedContent = content.replace(charToReplace, replacementChar)
    // Сохраняем измененное содержимое в новый файл
    val outputFile = File(outputFilePath)
    outputFile.writeText(modifiedContent)
    println("Содержимое файла было изменено и сохранено в $outputFilePath.")
}
fun change3() {
    val inputFilePath = "C:\\Users\\Ghost Smoke\\Desktop\\222.txt" // Путь к исходному файлу
    val outputFilePath = "C:\\Users\\Ghost Smoke\\Desktop\\333.txt" // Путь к выходному файлу
    val charToReplace = ',' // Символ, который нужно заменить
    val replacementChar = ' ' // Символ, на который нужно заменить
    // Читаем содержимое файла
    val inputFile = File(inputFilePath)
    // Заменяем символы
    val content = inputFile.readText()
    val modifiedContent = content.replace(charToReplace, replacementChar)
    // Сохраняем измененное содержимое в новый файл
    val outputFile = File(outputFilePath)
    outputFile.writeText(modifiedContent)
    println("Содержимое файла было изменено и сохранено в $outputFilePath.")
}
