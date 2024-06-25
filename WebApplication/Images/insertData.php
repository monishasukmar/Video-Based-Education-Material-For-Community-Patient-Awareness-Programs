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
$v1 = json_decode($_POST['v1'], true);
$stmt = $conn->prepare("INSERT INTO scores (patientname, patientphone, coursecode, prescore, postscore) VALUES (?, ?, ?, ?, ?)");
foreach ($v1 as $jsonObject) {
    $pname = $jsonObject['pname'];
    $pphno = $jsonObject['pphno'];
    $ccode = $jsonObject['ccode'];
    $spre = $jsonObject['spre'];
    $spost = $jsonObject['spost'];
    $stmt->bind_param("sssii", $pname,$pphno,$ccode,$spre,$spost);
    $stmt->execute();
}
$stmt->close();
$conn->close();
?>

 