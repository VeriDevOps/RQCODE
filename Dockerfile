FROM openjdk:11
ADD /target/RQCODE-1.0-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java","-cp","backend.jar","rqcode/stigs/canonical_ubuntu_18_04_lts/Main"]