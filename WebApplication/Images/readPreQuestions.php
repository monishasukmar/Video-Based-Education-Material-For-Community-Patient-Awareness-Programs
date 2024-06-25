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
$stmt = $conn->prepare("select Questions,Op1,Op2,Op3,Op4,Ans from quiz where CourseCode=?;");
$stmt->bind_param("s", $v1);
$stmt->execute();
$stmt->bind_result($Questions, $Op1,$Op2, $Op3,$Op4,$Ans);
$vals = array(); 
while($stmt->fetch()){
$temp = array();
$temp['Questions'] = $Questions; 
$temp['Op1'] = $Op1; 
$temp['Op2'] = $Op2; 
$temp['Op3'] = $Op3; 
$temp['Op4'] = $Op4; 
$temp['Ans'] = $Ans; 
array_push($vals, $temp);
}
echo json_encode($vals);
?>

 