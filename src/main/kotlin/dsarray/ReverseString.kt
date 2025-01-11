package dsarray

fun reverse(str: String): String = str.reversed() // Too easy :)

fun reverse2(str: String): String {
    return str
        .mapIndexed { index, c -> str[(str.length - 1) - index] }
        .joinToString("")
}

fun reverse3(str: String): String {

    var content = ""
    for (i in str.indices.reversed()) {
        content = content.plus(str[i])
    }

    return content
}

fun main() {

    println(reverse("ABC"))
    println(reverse2("ABC"))
    println(reverse3("ABC"))
}