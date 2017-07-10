echo "Replacing version string"
find . -type f -name '*.java' | xargs perl -pi -e 's|%BUILD_NUMBER%|$CIRCLE_BUILD_NUM|g'
find . -type f -name '*.yml' | xargs perl -pi -e 's|%BUILD_NUMBER%|$CIRCLE_BUILD_NUM|g'
echo "Building VLagger build $CIRCLE_BUILD_NUM ..."
mvn clean install