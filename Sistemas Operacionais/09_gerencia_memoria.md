<div align="center">

  # Gerência de Memória </div>

- deve prover mecanismos para que os processos utilizem a memória de forma segura e eficiente
- há várias técnicas de gerência
- cada SO emprega uma técnica em particular e isto depende fortemente de arquitetura do computador
- **memória** 


---
<div align="center">

  ## Ciclo de Execução de Instrução </div>

<div align="center">
  <img width="279" height="146" alt="{711CC047-2D2F-4E3E-A467-60F2CB616F27}" src="https://github.com/user-attachments/assets/82ca53a4-1dc2-46fb-8f81-8f955863cd25" />

</div>

---
<div align="center">  
  
  ## Mapeamento de Endereço</div>

- fila de 
<div align="center">
  <img width="486" height="274" alt="{2C2F9190-53EC-4508-AE59-1D8FDC6F1A51}" src="https://github.com/user-attachments/assets/aba1a691-5dbb-4ffa-8cc9-d809851f76c8" />

</div>

---

<div align="center">

  ## Espaço de Endereçamento - Lógico X Físico </div>

<div align="center">
  <img width="364" height="93" alt="{C98B5048-7EC2-4BB8-BEBA-047688E0C492}" src="https://github.com/user-attachments/assets/8a1b2e71-2e2c-4d24-bd82-f5ade4a9045f" />

</div>

---

<div align="center">

  ## Proteção de Memória </div>

- realizado pela MMU
- exemplo com registradores de limites
  - coonsidera que os endereços lógicos e físicos são idênticos
  - o conteúdo dos Registradores Limite define o espaço de endereçamento lógico do processo
  - nesses exemplo: espaço de endereçamento lógico é de 100 a 799   

<div align="center">
  <img width="344" height="110" alt="{717A1531-3E95-4686-B57D-A0C6FF18CC75}" src="https://github.com/user-attachments/assets/4fd0cf12-e26b-43ae-8424-1583f6eaf513" />

</div>

- exemplo com registrador limite e registrador base

<div align="center">
  <img width="367" height="110" alt="{A65B0338-8AB7-4927-A13D-6406577F853A}" src="https://github.com/user-attachments/assets/efba79cf-10e5-4572-bf20-8537f1ab1791" />

</div>

---

<div align="center">

  ## Swapping (troca)</div>

- um processo pode ser removido da memória temporariamente para um armazenamento auxiliar e retomado à memória para continuar a execução
- liberar memória
<div align="center">
  <img width="330" height="205" alt="{17F2D7F7-51A1-4606-818D-9A697A462490}" src="https://github.com/user-attachments/assets/d007c3c2-b770-4cfa-b611-b60009ab76fd" />
</div>

- geralmente, um processo que é descarregado será carregado no mesmo espaço de memória que ocupava anteriormente, isto é determinado pelo método de resolução de endereço
  - se for na carga ou montagem: processo não pode ser movido para posições diferentes
  - se for em tempo de execução: é possível passar para posições diferentes porque endereços físicos são calculados em tempo de execução   
