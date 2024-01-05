# ComPDFKit API in Java

## Introduction

[ComPDFKit](https://www.compdf.com/) offers powerful and steady PDF libraries and complete PDF functions to build PDF viewer and editor, which allows to preview, edit, annotate, sign, encrypt and decrypt PDF files.

[ComPDFKit API](https://api.compdf.com) provides a variety of Java API tools that allow you to create an efficient document processing workflow in a single API call.

ComPDFKit API allows you to get 1000 files processing monthly now! Just [sign up](https://api.compdf.com/signup) for a free trial and enjoy comprehensive PDF functions.

### Related

- ComPDFKit API - PHP Library: [ComPDFKit API - PHP Library](https://github.com/ComPDFKit/compdfkit-api-php)
- ComPDFKit API - C#.NET Library: [ComPDFKit API - C#.NET Library](https://github.com/ComPDFKit/compdfkit-api-.net)
- ComPDFKit API - Swift Library: [ComPDFKit API - Swift Library](https://github.com/ComPDFKit/compdfkit-api-swift)
- ComPDFKit API - Python Library: [ComPDFKit API - Python Library](https://github.com/ComPDFKit/compdfkit-api-python)
- [How to Build an Android PDF Viewer or Editor in Java](https://www.compdf.com/blog/build-an-android-pdf-viewer-or-editor)


## Requirements

Programming Environment: Java JDK 1.8 and higher.

Dependencies: Maven.



## Installation

You can install [the Maven Repository of ComPDFKit API Library](https://mvnrepository.com/artifact/com.compdf/compdfkit-api-java/1.3.2.0) directly using the Maven Repository. Alternatively, you can include the following dependency in your ***"pom.xml"*** file:

```
<dependency>
    <groupId>com.compdf</groupId>
    <artifactId>compdfkit-api-java</artifactId>
    <version>1.3.2.0</version>
</dependency>
```

## Usage

### Create API Client

First of all, please create an API client to complete the authentication. You need to [sign in](https://api.compdf.com/login) your ComPDFKit API account to get your **publicKey** and **secretKey** at the [dashboard](https://api-dashboard.compdf.com/api/keys). If you are new to ComPDFKit, click here to [sign up](https://api.compdf.com/signup) for a free trial to process 1,000 documents per month for free.

- Project public Key: You can find the public key in the **API Keys** section of your ComPDFKit API account.
- Project secret Key: You can find the secret Key in the **API Keys** section of your ComPDFKit API account.

```java
CPDFClient client = new CPDFClient(<publicKey>, <secretKey>);
```



### Create A Task

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



### Upload Files

Upload the original file and bind the file to the task ID. The field parameter is used to pass the JSON string to set the processing parameters for the file. Each file will generate automatically a unique **filekey**. Please note that a maximum of five files can be uploaded for a task ID and no files can be uploaded for that task after it has started.

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



### Execute the task

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



### Get The Task Info

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

## Examples

There are many examples in the **samples** folder, which show the main features of the ComPDFKit API and how to use them, such as watermarking PDFs, converting PDF to Word, Excel, JPG, PNG, etc. You can copy the code to your project and run it directly. To learn more about the ComPDFKit API, please visit our [API Reference](https://api.compdf.com/api-reference/overview).


## Free Trial

[ComPDFKit API](https://api.compdf.com/) is a powerful API that can be used to create an efficient document processing workflow in a single API call.

If you do not have a ComPDFKit API account, you can [sign up for a free trial](https://api.compdf.com/signup) to process 1,000 documents per month for free.

Once you have a ComPDFKit API account, you can obtain your **publicKey** and **secretKey** in the [dashboard](https://api-dashboard.compdf.com/api/keys).


## Support

[ComPDFKit](https://www.compdf.com/) has a professional R&D team that produces comprehensive technical documentation and guides to help developers. Also, you can get an immediate response when reporting your problems to our support team.

For detailed information, please visit our [Guides page](https://api.compdf.com/api/docs/guides).

Stay updated with the latest improvements through our [Changelog](https://www.compdf.com/api/changelog-compdfkit-api).

For technical assistance, please reach out to our [Technical Support](https://www.compdf.com/support).

To get more details and an accurate quote, please contact our [Sales Team](https://www.compdf.com/contact-sales).


## License

The code is available as open source under the terms of the [Apache-2.0 License](https://opensource.org/license/apache-2-0).