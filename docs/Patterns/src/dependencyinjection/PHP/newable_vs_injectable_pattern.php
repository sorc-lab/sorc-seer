<?php

// ensure that only a single instance exists for each class.
class Singleton
{
    // implements the 'singleton' design pattern.
    static function &getInstance ($class, $arg1 = null) {
        static $instances = array();  // array of instance names

        if (array_key_exists($class, $instances)) {
            // instance exists in array, so use it
            $instance =& $instances[$class];         
        }
        else {
            // load the class file (if not already loaded)
            if (!class_exists($class)) {
                switch ($class) {
                    case 'date_class':
                      require_once 'std.datevalidation.class.inc';
                      break;
                    case 'encryption_class':
                      require_once 'std.encryption.class.inc';
                      break;
                    case 'validation_class':
                        require_once 'std.validation.class.inc';
                        break;
                    default:
                        require_once "classes/$class.class.inc";
                        break;
                } // switch
            } // if

            // instance does not exist, so create it
            $instances[$class] = new $class($arg1);
            $instance =& $instances[$class];
        } // if

       return $instance;
    } // getInstance        
} // singleton

// NOTE: Can use the above resource locator w/ serialized obj. files?
// $objectFilePath = "/path/to/serialized/object/file";
// $di = unserialize(file_get_contents($objectFilePath));


// Entity class, newable
class Author
{
    private $id;
    private $data; // array
 
    public function __construct($id) {
        $this->id = $id;

        if ($id) {
            // instantiate AbstractTable Class
            // AbstractTable Class makes SQL query for record
            // AbstractTable Class makes DB_CONNECTION driver based on config.

            $db = Singleton::getInstance('DBConnection');
            $data = $db->getRecord();
        }
    }

    public function getData() { return $this->data; }
    public function getFirstName() { return $this->data['firstName']; }
    public function getLastName() { return $this->data['lastName']; }

    // obj. should have a getData() array, pulls from DB record on Author table
    // getFirst/LastName should pull from $data array
    // validate $id before even instantiating a DB connection obj.
}


// Entity class, newable
class Question
{
    private $question;

    public function __construct($question) { $this->question = $question; }
 
    public function getAuthor($id) {
        $this->author = Singleton::getInstance('Author', $id);
        return $this->author;
    }

    public function getQuestion() { return $this->question; }
}

// VS. using DI to inject Author $author into the Questions constructor, which
// instantiates an Author object which also may or may not hit a DB before the
// Author obj. is every used. In this case we can make a Question obj. without
// ever needing to know or care about an Author until we actually need to when
// we call 'getAuthor()'.

/*
class Author {
    private $firstName;
    private $lastName;
 
    public function __construct($firstName, $lastName) {
        $this->firstName = $firstName;
        $this->lastName = $lastName;
    }
 
    public function getFirstName() {
        return $this->firstName;
    }
 
    public function getLastName() {
        return $this->lastName;
    }
}


class Question {
    private $author;
    private $question;
    public function __construct($question, $authorFirstName, $authorLastName) {
        $this->author = new Author($authorFirstName, $authorLastName);
        $this->question = $question;
    }
 
    public function getAuthor() {
        return $this->author;
    }
 
    public function getQuestion() {
        return $this->question;
    }
}
*/
