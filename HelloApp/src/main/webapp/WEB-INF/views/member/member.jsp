<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Tiles가 적용된 member 페이지</h3>
<div>
	<!-- <form> -->
		id: <input type="text" id="id"><br>
		name: <input type="text" id="name"><br>
		pass: <input type="text" id="passwd"><br>
		mail: <input type="text" id="email"><br>
		auth: <input type="text" id="auth"><br>
		<button id="addBtn">등록</button>
	<!-- </form> -->
	<table class = "table">
		<thead>
			<tr><th>Id</th><th>Name</th><th>Pass</th><th>Mail</th><th>Auth</th><th>삭제</th></tr>
		</thead>
		<tbody id = "list">
		</tbody>
	</table>
</div>

<script>
	fetch('memberListAjax.do') // json 포맷으로 데이터 정상
	.then(function(resolve){
		//console.log(resolve);// body : readablestream
		return resolve.json();// json포맷에 다라 javascript object변경
	})
	.then(function(result){
		console.log(result); // result : [{},{},{},{},{}...{}]
		for(let i=0; i<result.length; i++){
			let id = result[i].id;
			let tr = document.createElement('tr');
			//td 만들기(아이디,이름,비번,메일,권한)
			for(let prop in result[i]){	//for..in..object의 필드 반복
			let td = document.createElement('td');
			td.innerText = result[i][prop];
			tr.append(td);
			}
			//삭제버튼
			let delBtn = document.createElement('button');//<button>삭제</button>
			delBtn.innerText = '삭제';
			delBtn.addEventListener('click', function(){
				console.log(this); //this => 이벤트 받는 대상(button)
				console.log(this.parentElement.parentElement.children[0].innerText);
				let delId = this.parentElement.parentElement.children[0].innerText;
				
				//ajax호출
				fetch('memberRemoveAjax.do',{
					method : 'post',
					headers : {'Content-Type' : 'application/x-www-form-urlencoded'},//key=val&key$val..
					body : 'id=' +delId
				})
				.then(resolve => resolve.json())
				.then(result => {
					console.log(result);
					if(result.retCode == 'Success'){
						alert('성공!');
						this.parentElement.parentElement.remove();//화면에서 지움 db에서는 안지워짐
					}else if(result.retCode == 'Fail'){
						alert('실패!');
					}
						
				})
				.catch(reject => console.log(reject));
			});
			let td = document.createElement('td');
			td.append(delBtn);//<td><button>삭제</button></td>
			tr.append(td);//<tr>  <td/><td/><td/>...<td/>  <td><button>삭제</button></td></tr>
			
			document.getElementById('list').append(tr);
		}
	})
	.catch(function(reject){
		console.error(reject);
	})
	
	//등록버튼 클릭이벤트
	document.getElementById('addBtn').addEventListener('click', function(){
		
		let id = document.querySelector('#id').value;
		let nm = document.querySelector('#name').value;
		let pw = document.querySelector('#passwd').value;
		let ma = document.querySelector('#email').value;
		let au = document.querySelector('#auth').value;
		
		
		
		
		if(!id || !nm || !pw || !ma || !au){
			alert("값을 입력!");
			return;
		}
		//ajax호출
		fetch('memberAddAjax.do', {
			method: 'post',
			headers: {'Content_Type': 'application/x-www-form-urlencoded'},
			body: 'id=?&name=?&pw=?$mail=?&auth=?'
		})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
		})
		.catch(reject => console.error(reject));
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</script>