function loadTable(){
    var work=document.forms['sc']['work'].value;
    var sd=document.forms['sc']['startdate'].value;
    var st=document.forms['sc']['starttime'].value;
    var dd=document.forms['sc']['duedate'].value;
    var dt=document.forms['sc']['duetime'].value;
    
    var rows="";
    rows+="<tr class='danger'><td>"+work+"</td><td>"+sd+"</td><td>"+st+"</td><td>"+dd+"</td><td>"+dt+"</td></tr>"
    $(rows).appendTo("#sct")
}

function visualizer(){
    var position=document.forms['sct']['position'].value;
    if(position==="manager"){
          document.getElementById('myBtn').style.visibility='hidden';
       
       }
    
}