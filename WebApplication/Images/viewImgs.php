<?php 
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', 'root');
define('DB_NAME', 'app');
$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
if (mysqli_connect_errno()) {
echo "Failed to connect to MySQL: " . mysqli_connect_error();
die();
}
$v1 = $_POST["v1"];
$stmt = $conn->prepare("SELECT path FROM imgs where ccode=?;");
$stmt->bind_param("s", $v1);
$stmt->execute();
$stmt->bind_result($path);
$vals = array(); 
while($stmt->fetch()){
$temp = array();
$temp['paths'] = $path; 
array_push($vals, $temp);
}
echo json_encode($vals);
?>

 