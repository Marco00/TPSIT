<B> Risorse Condivise </B> <HR>
<BODY>
Il programma RisorseCondivise è formato da due classi e tre programmi di prova. <BR>

<UL>
  
	Risorse: classe contenente le risorse utilizzate dai thread.
  
	Task: classe che implementa l'interfaccia Runnable e include il metodo run(), il quale permette ai thread di acquisire e rilasciare le risorse.
  
	Simul1: esercizio in cui due thread cercano di accedere alla stessa risorsa ma per poterla utilizzare, un thread deve aspettare che l'altro la rilasci in modo tale da non entrare nella zona vietata ossia, un'area in cui la risorsa sarebbe accessibile contemporaneamente ad entrambi i thread .
  
	Simul2: esercizio in cui due thread possono accedere a due risorse diverse nello stesso ordine però ogni thread deve aspettare l'altro finchè non finisce di utilizzarle. Il thread, per un certo momento, può usufruire contemporaneamente di entrambe le risorse.
  
	Simul3: esercizio simile al precedente con la variante che le risorse vengono acquisite dai due thread con un ordine diverso dando vita ad un deadlock.

</UL>
</BODY>
