viagens(5).
guarda(peq).

!start.

+!start : true 
    <-
        ?viagens(Qtd);
        ?guarda(Peca);
        .print("sou responsavel pelas peças",Peca, "e tenho", Qtd, "viagens").

+peca(Peca) : viagens(Qtd) & Qtd >0 & guarda(Peca) 
    <-
        .print("percebi uma peça ", Peca, "e vou guarda-la");
        guardar(Peca).

+peca(Peca) : guarda(Peca) 
    <-
        .print("percebi uma peça ", Peca, " mas não tenho mais como guardar peças").