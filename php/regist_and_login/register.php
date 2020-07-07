<?php

if($_SERVER['REQUEST_METHOD'] =='POST'){
    $user = $_POST['user'];
    $email = $_POST['email'];
    $pass = $_POST['pass'];
    $code = $_POST['code'];
    $pesan = $_POST['pesan'];

    require_once 'connect.php';

    $sql = "INSERT INTO users_table (user, email, pass, code, pesan) VALUES ('$user', '$email', '$pass', '$code', '$pesan')";

    $result = array();

    if ( mysqli_query($conn, $sql) ){
        $result["success"] = "1";
        $result["message"] = "success";
        
        echo json_encode($result);
        mysqli_close($conn);
    } else {
        $result["success"] = "0";
        $result["message"] = "error";
        echo($result);

        echo json_encode($result);
        mysqli_close($conn);
    }
}

?>