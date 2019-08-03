var table: Array<Array<String>> = arrayOf(arrayOf("-","-","-"),
    arrayOf("-","-","-"),
    arrayOf("-","-","-"))
var turn = 1;
var rowIn = 0;
var colIn = 0;

fun main(){
    welcome()
    while (turn<10){
        checkWin()
        showTable(table)
        showTurn(turn)
        input()
        turn+=1
    }
}

fun showTable(x: Array<Array<String>>){
    println("  1 2 3")
    for (i in x.indices){
        print("${i+1} ")
        for (j in x[i].indices){
            print("${x[i][j]} ")
        }
        println()
    }
}

fun welcome(){
    println("Welcome to XO game")
}

fun showTurn(x: Int){
    if (x%2 == 0){
        println("O turn")
    }else{
        println("x turn")
    }
}

fun input(){
    try {
        while (true){
            print("Please input row col: ")
            val input:String? = readLine()
            val rcList = input?.split(" ")
            if (rcList?.size != 2 ){
                println("Try Again")
                continue
            }
            rowIn = rcList[0].toInt()
            colIn = rcList[1].toInt()

            if (rowIn <1 || rowIn  >3){
                println("Try Again")
                continue
            }

            if (colIn<1 || colIn >3){
                println("Try Again")
                continue
            }
            if (!table[rowIn-1][colIn-1].equals("-")){
                println("is not empty")
                continue
            }

            if(turn%2==0){
                table[rowIn-1][colIn-1] = "O"
            }else{
                table[rowIn-1][colIn-1] = "X"
            }

            break
        }
    }catch (t: Throwable){
        println("Please input only number")
    }

}

fun checkWin(){
    while (true){
        var checkRow = "${table[0][0]}${table[0][1]}${table[0][2]}"
        var checkRow2 = "${table[1][0]}${table[1][1]}${table[1][2]}"
        var checkRow3 = "${table[2][0]}${table[2][1]}${table[2][2]}"

        var checkcol = "${table[0][0]}${table[1][0]}${table[2][0]}"
        var checkcol2 = "${table[0][1]}${table[1][1]}${table[2][1]}"
        var checkcol3 = "${table[0][2]}${table[1][2]}${table[2][2]}"

        var checkCross = "${table[0][0]}${table[1][1]}${table[2][2]}"
        var checkCross2 = "${table[0][2]}${table[1][1]}${table[2][0]}"

        if (checkRow.equals("XXX") || checkRow2.equals("XXX") || checkRow3.equals("XXX") || checkcol.equals("XXX") || checkcol2.equals("XXX")
            || checkcol3.equals("XXX") || checkCross.equals("XXX") || checkCross2.equals("XXX")){
            println("X Win")
            turn =10
            break
        }

        if (checkRow.equals("OOO") || checkRow2.equals("OOO") || checkRow3.equals("OOO") || checkcol.equals("OOO") || checkcol2.equals("OOO")
            || checkcol3.equals("OOO") || checkCross.equals("OOO") || checkCross2.equals("OOO")){
            println("O Win")
            turn =10
            break
        }

        if (turn==9){
            println("Draw!")
            break
        }

        break
    }

}