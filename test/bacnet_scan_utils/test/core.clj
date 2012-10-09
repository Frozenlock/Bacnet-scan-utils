(ns bacnet-scan-utils.test.core
  (:use [bacnet-scan-utils.bacnet])
  (:use [clojure.test]))


(deftest live-tests
    "To run this test you must have the the bacserv.exe running as the
device 1234 on your network. (Probably with a different machine, as it
will use the same port as this library.)"
    (let [old-data (:objects (:1234 (:data (read-string (slurp "test/bacnet_scan_utils/test/test-data.log")))))
          new-data (:objects (:1234 (:data (bacnet-test))))]
      (when (some #(= 1234 %) (get-remote-devices-list))
        (testing "Data format"
          (is (= old-data new-data) "Test data format with a live bacnet device"))
        (testing "Filter remote devices"
          (is (not (empty? (with-local-device (new-local-device)
                             (keep-devices-by-id (get-remote-devices-and-info) [1234])))))))))


(deftest filter-with-properties
  (let [devices-db (:data (read-string (slurp "test/bacnet_scan_utils/test/test-data.log")))]
    (is (=
         (filter-by-properties devices-db [{:Model-name "GNU"}]) {}) "Filter with correct name")
    (is (not (=
              (filter-by-properties devices-db [{:Model-name "Wrong-name"}]) {}))  "Filter with wrong name")))
