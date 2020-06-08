
// 10回Helloという

for (i <- 0 to 10) println("Hello")

// 2重ループ
for (i <- 0 to 10; j <- 0 to 10) println(s"$i, $j")

// 条件付きループ
// 予想する結果 0 0 1 1 2 2
for (i <- 0 to 5; j <- 0 to 5 if i == j) println(s"$i, $j")
for (i <- 0 to 3; j <- 0 to 3 if i != j) println(s"$i, $j")

// forの実行結果を返す

val result = for (i <- 0 to 3) yield s"Hello $i"
println(result)
