<?php

if($_SERVER['REQUESt_METHOD'] == 'POST') {

    $id = $_POST['id'];
    $photo = $_POST['photo'];

    $path = "profile_image/$id.jpeg";
    $finalPath = "http://192.168.1.10/android_register_login/".$path;

    require_once 'connect.php';

    $sql = "UPDATE users_tale set photo='$finalPath" where id='$id'";

    if(mysqli_query($conn,$sql)){
        
        if( file_put_contents($path, base64_decode($photo) ) ) {

            $result['success'] = "1";
            $result['message'] = "success";

            echo json_encode($result);
            mysqli_close($conn);

        }
    
    }

}

?>