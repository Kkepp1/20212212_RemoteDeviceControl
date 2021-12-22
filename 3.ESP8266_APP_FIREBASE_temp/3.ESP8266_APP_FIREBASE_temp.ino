#include <DHT.h>
#include <ArduinoJson.h>
#include "FirebaseESP8266.h"
#include <ESP8266WiFi.h>


#define WIFI_SSID "jupiter"
#define WIFI_PASSWORD "12345678"
#define FIREBASE_HOST "v2-a30b4-default-rtdb.firebaseio.com"
#define FIREBASE_AUTH "s8TTljCp8MepmgbmH55oFV9yT9YmWVfE41nB8IBR"
FirebaseData firebaseData;
FirebaseJson json;

#define chandht 4
#define loaidht DHT11
DHT dht(chandht,loaidht);
float nhietdo;
float doam;

String path = "/";

byte x =0;
String a,b,c;// giá trị đọc đk đèn

int led = 15;
int led2 = 14;
int led3 = 12;
int button = 13;

void setup() {
  // put your setup code here, to run once:
Serial.begin(115200);
 pinMode(led,OUTPUT);
 pinMode(led2,OUTPUT);
 pinMode(led3,OUTPUT);
 pinMode(button,INPUT_PULLUP);
 digitalWrite(led,0);
 digitalWrite(led2,0);
 digitalWrite(led3,0);

 pinMode(chandht,INPUT);//// start dht
 dht.begin();

WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
Serial.print("connecting");
while (WiFi.status() != WL_CONNECTED) {
Serial.print(".");
delay(500);
}

Serial.println();
Serial.print("connected with: ");
Serial.println(WIFI_SSID);

Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);
Firebase.reconnectWiFi(true);
if(!Firebase.beginStream(firebaseData, path))
 {
  Serial.println("reason: " + firebaseData.errorReason());
  Serial.println();
  }
Firebase.setString(firebaseData, path + "denT1","tat");
Firebase.setString(firebaseData, path + "denT2","tat");
Firebase.setString(firebaseData, path + "denT3","tat");
}

void loop() {
     int e = digitalRead(button);// doc trang thai nut nhan

     nhietdo = dht.readTemperature();
     doam = dht.readHumidity();
  Firebase.setFloat(firebaseData, path + "/temp",nhietdo);
  Firebase.setFloat(firebaseData, path + "/humidity",doam);
   ///// dèn 1
   if(Firebase.getString(firebaseData, path + "denT1"))   a= firebaseData.stringData();
    Serial.println(a);
  
    if (a =="bat") {
    Serial.println("Led Turned ON");
    digitalWrite(led, HIGH);
       }
       
   else if (a == "tat") {
    Serial.println("Led Turned OFF");
    digitalWrite(led, LOW);
        }
 ///// den2 
  if(Firebase.getString(firebaseData, path + "denT2"))   b= firebaseData.stringData();
    Serial.println(a);
  
    if (b =="bat") {
    Serial.println("Led Turned ON");
    digitalWrite(led2, HIGH);
       }
       
   else if (b == "tat") {
    Serial.println("Led Turned OFF");
    digitalWrite(led2, LOW);
        } 
 /////den3
  if(Firebase.getString(firebaseData, path + "denT3"))   c= firebaseData.stringData();
    Serial.println(a);
  
    if (c =="bat") {
    Serial.println("Led Turned ON");
    digitalWrite(led3, HIGH);
       }
       
   else if (c == "tat") {
    Serial.println("Led Turned OFF");
    digitalWrite(led3, LOW);  
     }
}
