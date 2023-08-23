## ComPDFKit API in Java

[ComPDFKit](https://api.compdf.com/api/docs/introduction) API provides a variety of Java API tools that allow you to create an efficient document processing workflow in a single API call. Try our various APIs for free — no credit card required.



## Requirements

Programming Environment: Java JDK 1.8 and higher.

Dependencies: Maven.



## Installation

Add the following dependency to your ***"pom.xml"***:

```
<dependency>
    <groupId>com.compdf</groupId>
    <artifactId>compdfkit-api-java</artifactId>
    <version>1.3.2</version>
</dependency>
```



## Create API Client

You can use your **publicKey** and **secretKey** to complete the authentication. You need to [sign in](https://api.compdf.com/login) your ComPDFKit API account to get your **publicKey** and **secretKey** at the [dashboard](https://api-dashboard.compdf.com/api/keys). If you are new to ComPDFKit, click here to [sign up](https://api.compdf.com/signup) for a free trial.

- Project public Key : You can find the public key in [Management Panel](https://api-dashboard.compdf.com/api/keys).

- Project secret Key : You can find the secret Key in [Management Panel](https://api-dashboard.compdf.com/api/keys).

```java
CPDFClient client = new CPDFClient(<publicKey>, <secretKey>);
```



## Create Task

A task ID is automatically generated for you based on the type of PDF tool you choose. You can provide the callback notification URL. After the task processing is completed, we will notify you of the task result through the callback interface. You can perform other operations according to the request result, such as checking the status of the task, uploading files, starting the task, or downloading the result file.

```java
// Create a client
CPDFClient client = new CPDFClient(<publicKey>, <secretKey>);

// Create a task
// Create an example of a PDF TO WORD task
CPDFCreateTaskResult result = client.createTask(CPDFConversionEnum.PDF_TO_WORD.getValue());

// Get a task id
String taskId = result.getTaskId();
```



## Upload Files

Upload the original file and bind the file to the task ID. The field parameter is used to pass the JSON string to set the processing parameters for the file. Each file will generate automatically a unique filekey. Please note that a maximum of five files can be uploaded for a task ID and no files can be uploaded for that task after it has started.

```java
// Create a client
CPDFClient client = new CPDFClient(<publicKey>, <secretKey>);

// Create a task
// Create an example of a PDF TO WORD task
CPDFCreateTaskResult result = client.createTask(CPDFConversionEnum.PDF_TO_WORD.getValue());

// Get a task id
String taskId = result.getTaskId();

// Upload files
client.uploadFile(<convertFile>, taskId);
```



## Execute the task

After the file upload is completed, call this interface with the task ID to process the files.

```java
// Create a client
CPDFClient client = new CPDFClient(<publicKey>, <secretKey>);

// Create a task
// Create an example of a PDF TO WORD task
CPDFCreateTaskResult result = client.createTask(CPDFConversionEnum.PDF_TO_WORD.getValue());

// Get a task id
String taskId = result.getTaskId();

// Upload files
client.uploadFile(<convertFile>, taskId);

// execute Task
client.executeTask(taskId, CPDFLanguageConstant.English);
```



## Get Task Info

Request task status and file-related meta data based on the task ID.

```java
// Create a client
CPDFClient client = new CPDFClient(<publicKey>, <secretKey>);

// Create a task
// Create an example of a PDF TO WORD task
CPDFCreateTaskResult result = client.createTask(CPDFConversionEnum.PDF_TO_WORD.getValue());

// Get a task id
String taskId = result.getTaskId();

// Upload files
client.uploadFile(<convertFile>, taskId);

// Execute Task
client.executeTask(taskId, CPDFLanguageConstant.English);

// Query TaskInfo
CPDFTaskInfoResult taskInfo = client.getTaskInfo(taskId);
```



## Samples

See ***"Samples"*** folder in this folder.



## Resources
* [ComPDFKit API Libraries](https://api.compdf.com/api-libraries/overview)
* [ComPDFKit API Documentation](https://api.compdf.com/api/docs/introduction)
