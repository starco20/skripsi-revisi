<?php 

require_once 'connect.php';

$type = $_GET['item_type'];

if (isset($_GET['key'])) {
    $key = $_GET["key"];
    if ($type == 'users') {
        $query = "SELECT * FROM users_table WHERE email LIKE '%$key%'";
        $result = mysqli_query($conn, $query);
        $response = array();
        while( $row = mysqli_fetch_assoc($result) ){
            array_push($response, 
            array(
                'id'=>$row['id'], 
                'code'=>$row['code'], 
                'pesan'=>$row['pesan'])
            );
        }
        echo json_encode($response);   
    }
} else {
    if ($type == 'users') {
        $query = "SELECT * FROM users1";
        $result = mysqli_query($conn, $query);
        $response = array();
        while( $row = mysqli_fetch_assoc($result) ){
            array_push($response, 
            array(
                'id'=>$row['id'], 
                'code'=>$row['code'], 
                'pesan'=>$row['pesan']) 
            );
        }
        echo json_encode($response);   
    }
}

mysqli_close($conn);

?>