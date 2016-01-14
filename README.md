criteria： null exception
criteria: 0 false
criteria: 1 
		weight Don't care true 
			   others
			   		**answer.match(criterion.getAnswer()) true
			   		! answer.match(criterion.getAnswer()) 
			   			criterion.getWeight() == Weight.MustMatch false
			   			! criterion.getWeight() == Weight.MustMatch false



criteria: 2 
			1)
			weight Don't care  true  2) weight don't care  true  => true score + 2
									** 2)  answer.match(criterion.getAnswer() => true score + 2
									2)  !answer.match(criterion.getAnswer()
											criterion.getWeight() == Weight.MustMatch false   score score + 1

											!criterion.getWeight() == Weight.MustMatch true
											score + 1

			   others
			   		*** answer.match(criterion.getAnswer()) true  2) don't care true => true score +2
			   													** 2) answer.match(criterion.getAnswer()  true score +2
			   													2) !answer.match(criterion.getAnswer() 
			   														criterion.getWeight() == Weight.MustMatch false score + 1

			   														!criterion.getWeight() == Weight.MustMatch true score + 1

			   		! answer.match(criterion.getAnswer()) 
			   			criterion.getWeight() == Weight.MustMatch false

			   					2) don't care  true score + 1
			   					**2) answer.match(criterion.getAnswer()) true score + 1
			   					2) !answer.match(criterion.getAnswer()) 
			   							criterion.getWeight() == Weight.MustMatch false score + 1
			   							!criterion.getWeight() == Weight.MustMatch false score

			   			! criterion.getWeight() == Weight.MustMatch false
			   					2) dont care false score + 1
			   					**2) answer.match(criterion.getAnswer()) false score + 1
			   					2)!answer.match(criterion.getAnswer()) 
			   					    criterion.getWeight() == Weight.MustMatch false 
			   					    !criterion.getWeight() == Weight.MustMatch false
 
