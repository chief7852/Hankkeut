<!DOCTYPE html>
<title> WebSocket Image Drop </title>

<h2> Drop an image here. </he>

<script>
 var ws = new WebSocket("ws://localhost:8032/wcggame/websocktMultiChat");

 ws.onopen = function(e) {
  console.log("Connected.");
 }

 ws.onmessage = function(e) {
  var blob = e.data;

  console.log("New Message : " + blob.size + " byte");
  
  // works cross-browser
  var uri = createObjectURL(blob);
  var img = document.createElement("img");
  img.src = uri;

  document.body.appendChild(img);
 }

 document.ondrop = function(e) {
  document.body.style.backgroundColor = "#660000";

  try {
   /*
      e.preventDefault() 메서드는 기본 이벤트 발생을 
      방지해 주는데 이 부분을 제거하고 탐색기에서
      이미지 파일을 Drop하면 그냥 그 파일이 브라우져에서 열립니다.
      URL을 보시면 그 이미지 파일 경로로 변경된걸 보실 수 있습니다.
      e.preventDefault() 메서드를 호출함으로 해서 그런 현상이
      나오지 않고 handleFileDrop 함수가 이미지를 처리하게 됩니다.
   */
   e.preventDefault();  
   handleFileDrop(e.dataTransfer.files[0]);
   return false;
  } catch(err) {
   console.log(err);
  }
 }

 document.ondragover = function(e) {
  e.preventDefault();
  document.body.style.backgroundColor = "#66FF00";
 }
 
 document.ondragleave = function(e) {
  document.body.style.backgroundColor = "#660000";
 }

 function handleFileDrop(file) {
  var reader = new FileReader();
  reader.readAsArrayBuffer(file);
  reader.onload = function() {
   console.log("Receiving " + file.name);
   /*
              echo server로 보내면 서버는 받아서 그대로 다시 보내줌으로 해서
     위의 onmessage이벤트가 발생하게 된다.
   */
   ws.send(reader.result);
  }
 }

 // BLOB데이터를 가지고 URL객체를 만들어 내는 함수
 function createObjectURL (blob) {
  if ( window.webkitURL ) {
   return window.webkitURL.createObjectURL( blob );
  } else if ( window.URL && window.URL.createObjectURL ) {
   return window.URL.createObjectURL( blob );
  } else {
   return null;
  }
 }
</script> 



출처: https://imaitman.tistory.com/235?category=516720 [To be rich..]