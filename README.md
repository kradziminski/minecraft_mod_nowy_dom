# minecraft_mod_nowy_dom

Mod do Minecrafta uzywajacy wersji 1.8 Minecraft Forge.

## Setup

* Sklonuj repozytorium
* Uruchom `gradlew setupDecompWorkspace` by przygotowac srodowisko programistyczne
* Uruchom `gradlew build` by skompilowac moda
* Uruchom `gradlew runServer` by uruchomic serwer pierwszy raz, powinien wygenerowac katalog `eclipse`
* Zmien w pliku `eclipse\eula.txt` `eula=false` na `eula=true`
* Uruchom `gradlew runServer` by uruchomic serwer drugi raz, powinien wygenerowac plik `server.properties`
* Zmien w pliku `eclipse\server.properties` `online-mode=true` na `online-mode=false`
* Uruchom `gradlew runServer` by uruchomic serwer trzeci raz - tym razem powinien zadzialac
* Uruchom `gradlew runClient` by uruchomic klienta
* Podlacz sie klientem pod lokalny serwer (`localhost`) i podziwiaj swoj nowy dom :-)