# Temporal image for RQCODE compilation
FROM maven:3-jdk-11 AS maven_builder
COPY . /build
WORKDIR /build/
RUN mvn -f ./pom.xml clean package
# The product (testing) image
FROM ubuntu:18.04
USER root
# Add test scripts required for execution
ADD ./src/main/java/rqcode/stigs/canonical_ubuntu_18_04_lts/ /RQCODE/src/main/java/rqcode/stigs/canonical_ubuntu_18_04_lts/
# Copy compiled RQCODE’s execution file

COPY --from=maven_builder /build/target/RQCODE-1.0-SNAPSHOT.jar /usr/share/RQCODE.jar
# We need to install and remove the package at the same layer because of layers state saving.

RUN apt-get update --fix-missing && \
apt-get install -y openjdk-11-jre-headless --fix-missing && \
apt-get clean && \
ln -s /RQCODE/src /src && \
find /src/main/java/rqcode/stigs/canonical_ubuntu_18_04_lts/ -type f -iname "*.sh" -exec chmod +x {} \;

ENTRYPOINT ["java", "-cp", "/usr/local/rqcode.jar", "rqcode.stigs.canonical_ubuntu_18_04_lts.Main"]
