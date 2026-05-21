viagens(10).
guarda(med).

!start.

+!start : true 
    <-
        ?viagens(Qtd);
        ?guarda(Peca);
        .print("sou responsavel pelas peças",Peca, "e tenho", Qtd, "viagens").
