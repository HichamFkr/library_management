/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function v(){
    document.getElementById('password').style.borderColor="red";
}
function openSlideMenu(){
  document.getElementById('side-menu').style.width = '270px';
  document.getElementById('sousnavbar').style.width = '270px';
  document.getElementById('table').style.marginLeft='300px';
  document.getElementById('titre').style.marginLeft='300px'; 
}
function closeSlideMenu(){
  document.getElementById('side-menu').style.width = '0';
  document.getElementById('table').style.marginLeft='auto';
  document.getElementById('titre').style.marginLeft='180px';
}

 function dialog(){
        document.getElementById('dialogue').style.display='block';
    }
    
function closeDialogue(){
    document.getElementById('dialogue').style.display='none';
}
function reset(){
    var items = document.getElementsByTagName('input');
    for (var i =0 ; i<items.length;i++){
        alert(items[i]);
    }
}