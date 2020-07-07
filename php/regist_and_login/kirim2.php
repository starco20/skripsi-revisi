<?php
require "connect2.php";

// $name = $_POST["name"];
// $password = $_POST["password"];
// $address = $_POST["address"];

$email = $_POST["email"];
$photo1 = $_POST["photo1"];


$sql = "update users_table set photo1 = '$photo1' where email = '$email'";

if(mysqli_query($con,$sql))
{

echo " Succesfully update";

}
else
{
echo "Try again Later ..." .mysqli_error($con) ;

}
?>