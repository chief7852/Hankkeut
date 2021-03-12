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
      e.preventDefault() ë©ìëë ê¸°ë³¸ ì´ë²¤í¸ ë°ìì 
      ë°©ì§í´ ì£¼ëë° ì´ ë¶ë¶ì ì ê±°íê³  íìê¸°ìì
      ì´ë¯¸ì§ íì¼ì Dropíë©´ ê·¸ë¥ ê·¸ íì¼ì´ ë¸ë¼ì°ì ¸ìì ì´ë¦½ëë¤.
      URLì ë³´ìë©´ ê·¸ ì´ë¯¸ì§ íì¼ ê²½ë¡ë¡ ë³ê²½ëê±¸ ë³´ì¤ ì ììµëë¤.
      e.preventDefault() ë©ìëë¥¼ í¸ì¶í¨ì¼ë¡ í´ì ê·¸ë° íìì´
      ëì¤ì§ ìê³  handleFileDrop í¨ìê° ì´ë¯¸ì§ë¥¼ ì²ë¦¬íê² ë©ëë¤.
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
              echo serverë¡ ë³´ë´ë©´ ìë²ë ë°ìì ê·¸ëë¡ ë¤ì ë³´ë´ì¤ì¼ë¡ í´ì
     ìì onmessageì´ë²¤í¸ê° ë°ìíê² ëë¤.
   */
   ws.send(reader.result);
  }
 }

 // BLOBë°ì´í°ë¥¼ ê°ì§ê³  URLê°ì²´ë¥¼ ë§ë¤ì´ ë´ë í¨ì
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



ì¶ì²: https://imaitman.tistory.com/235?category=516720 [To be rich..]