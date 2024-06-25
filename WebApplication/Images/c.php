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

$stmt = $conn->prepare("select * from courses;");
$stmt->execute();
$stmt->bind_result($id, $name,$pwd);
$vals = array(); 
while($stmt->fetch()){
$temp = array();
$temp['id'] = $id; 
$temp['ccode'] = $name; 
$temp['cname'] = $pwd; 
array_push($vals, $temp);
}
echo json_encode($vals);
?>
