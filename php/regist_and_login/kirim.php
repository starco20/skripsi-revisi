<?php
require "connect2.php";

$email = $_POST["email"];
$tempatlahir = $_POST["tempatlahir"];
$tanggallahir = $_POST["tanggallahir"];
$userjeniskelamin = $_POST["userjeniskelamin"];
$usergolongandarah = $_POST["usergolongandarah"];
$usersukuasalmarga = $_POST["usersukuasalmarga"];
$userdesa = $_POST["userdesa"];
$userkecamatan = $_POST["userkecamatan"];
$userkabupaten = $_POST["userkabupaten"];
$userpropinsi = $_POST["userpropinsi"];
$userkodepos = $_POST["userkodepos"];
$usernohp = $_POST["usernohp"];
$userstatus = $_POST["userstatus"];
$useragama = $_POST["useragama"];
$userasalsma = $_POST["userasalsma"];
$asdesa = $_POST["asdesa"];
$askecamatan = $_POST["askecamatan"];
$askabupaten = $_POST["askabupaten"];
$aspropinsi = $_POST["aspropinsi"];
$askodepos = $_POST["askodepos"];
$fatnama = $_POST["fatnama"];
$fatdesa = $_POST["fatdesa"];
$fatkecamatan = $_POST["fatkecamatan"];
$fatkabupaten = $_POST["fatkabupaten"];
$fatpropinsi = $_POST["fatpropinsi"];
$fatkodepos = $_POST["fatkodepos"];
$fatnohp = $_POST["fatnohp"];
$fatemail = $_POST["fatemail"];
$fatpendidikan = $_POST["fatpendidikan"];
$fatagama = $_POST["fatagama"];


$ibunama = $_POST["ibunama"];
$ibudesa = $_POST["ibudesa"];
$ibukecamatan = $_POST["ibukecamatan"];
$ibukabupaten = $_POST["ibukabupaten"];
$ibupropinsi = $_POST["ibupropinsi"];
$ibukodepos = $_POST["ibukodepos"];
$ibunohp = $_POST["ibunohp"];
$ibuemail = $_POST["ibuemail"];
$ibupendidikan = $_POST["ibupendidikan"];
$ibuagama = $_POST["ibuagama"];

$wlnama = $_POST["wlnama"];
$wldesa = $_POST["wldesa"];
$wlkecamatan = $_POST["wlkecamatan"];
$wlkabupaten = $_POST["wlkabupaten"];
$wlpropinsi = $_POST["wlpropinsi"];
$wlkodepos = $_POST["wlkodepos"];
$wlnohp = $_POST["wlnohp"];
$wlemail = $_POST["wlemail"];
$wlpendidikan = $_POST["wlpendidikan"];
$wlagama = $_POST["wlagama"];

$sql = "update users_table set tempatlahir = '$tempatlahir',
tanggallahir = '$tanggallahir',
userjeniskelamin = '$userjeniskelamin',
usergolongandarah = '$usergolongandarah',
usersukuasalmarga = '$usersukuasalmarga',
userdesa = '$userdesa',
userkecamatan = '$userkecamatan',
userkabupaten = '$userkabupaten',
userpropinsi = '$userpropinsi',
userkodepos = '$userkodepos',
usernohp = '$usernohp',
userstatus = '$userstatus',
useragama = '$useragama',
userasalsma = '$userasalsma',
asdesa = '$asdesa',
askecamatan = '$askecamatan',
askabupaten = '$askabupaten',
aspropinsi = '$aspropinsi',
askodepos = '$askodepos',
fatnama = '$fatnama',
fatdesa = '$fatdesa',
fatkecamatan = '$fatkecamatan',
fatkabupaten = '$fatkabupaten',
fatpropinsi = '$fatpropinsi',
fatkodepos = '$fatkodepos',
fatnohp = '$fatnohp',
fatemail = '$fatemail',
fatpendidikan = '$fatpendidikan',
fatagama = '$fatagama',

ibunama = '$ibunama',
ibudesa = '$ibudesa',
ibukecamatan = '$ibukecamatan',
ibukabupaten = '$ibukabupaten',
ibupropinsi = '$ibupropinsi',
ibukodepos = '$ibukodepos',
ibunohp = '$ibunohp',
ibuemail = '$ibuemail',
ibupendidikan = '$ibupendidikan',
ibuagama = '$ibuagama',

wlnama = '$wlnama',
wldesa = '$wldesa',
wlkecamatan = '$wlkecamatan',
wlkabupaten = '$wlkabupaten',
wlpropinsi = '$wlpropinsi',
wlkodepos = '$wlkodepos',
wlnohp = '$wlnohp',
wlemail = '$wlemail',
wlpendidikan = '$wlpendidikan',
wlagama = '$wlagama'

where email = '$email'";

if(mysqli_query($con,$sql))
{

echo "Berkas Telah Terkirim silahkan cek Pesan Dinotifikasi untuk info lebih lanjut";

}
else
{
echo "Try again Later ..." .mysqli_error($con) ;

}
?>
